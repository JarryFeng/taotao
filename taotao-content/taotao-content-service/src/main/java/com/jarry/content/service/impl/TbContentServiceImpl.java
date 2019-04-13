package com.jarry.content.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jarry.content.service.TbContentService;
import com.jarry.mapper.TbContentCategoryMapper;
import com.jarry.mapper.TbContentMapper;
import com.jarry.myenum.UseStatusEnum;
import com.jarry.pojo.TbContent;
import com.jarry.pojo.TbContentCategory;
import com.jarry.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/12
 * @describe 内容管理
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Autowired
    TbContentMapper tbContentMapper;

    @Autowired
    TbContentCategoryMapper tbContentCategoryMapper;

    /**
     * 获取内容分类
     *
     * @param parentId
     * @return
     */
    public List<TbContentCategory> getContentCategoryList(Long parentId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);

        return tbContentCategoryMapper.selectByCondition(tbContentCategory);
    }

    @Override
    public TbContentCategory saveContentCategory(Long parentId, String name) {

        TbContentCategory tcc = new TbContentCategory();
        tcc.setCreated(new Date());
        tcc.setParentId(parentId);
        tcc.setIsParent(false);
        tcc.setName(name);
        tcc.setSortOrder(0);
        tcc.setStatus(UseStatusEnum.正常.getCode());
        tcc.setUpdated(new Date());

        tbContentCategoryMapper.insert(tcc);

        //将父节点设置isParent为true
        TbContentCategory ptcc = new TbContentCategory();
        ptcc.setId(parentId);
        ptcc.setIsParent(true);
        tbContentCategoryMapper.updateByPrimaryKey(ptcc);

        return tcc;
    }

    @Override
    public int updateContentCategory(TbContentCategory tbContentCategory) {
        return tbContentCategoryMapper.updateByPrimaryKey(tbContentCategory);
    }

    @Override
    public int deleteContentCategory(Long parentId, Long id) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        //查出同该删除节点的为弟节点的集合
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByCondition(tbContentCategory);

        if (tbContentCategories == null) {

        } else if (tbContentCategories.size() <= 1) {
            //没有子节点了，父节点就设置成false
            TbContentCategory parent = new TbContentCategory();
            parent.setId(parentId);
            parent.setIsParent(false);
            tbContentCategoryMapper.updateByPrimaryKey(parent);
        }

        return removeChild(id, 0);
    }

    private int removeChild(Long parentId, int count){

        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        //查询是否有子节点
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByCondition(tbContentCategory);
        if(tbContentCategories != null && tbContentCategories.size()> 0){
            for(TbContentCategory tcc : tbContentCategories){
                count += removeChild(tcc.getId(), 0);
            }
        }

        tbContentCategoryMapper.deleteByPrimaryKey(parentId);
        return ++count;
    }


    @Override
    public PageInfo<TbContent> getContentList(Long categoryId, int rows, int page) {
        PageHelper.startPage(page, rows);
        List<TbContent> tbContents = tbContentMapper.selectByCatagoryId(categoryId);
        PageInfo<TbContent> pageInfo = new PageInfo(tbContents);
        return pageInfo;
    }


}
