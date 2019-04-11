package com.jarry.service.impl;

import com.jarry.mapper.TbItemCatMapper;
import com.jarry.pojo.TbItemCat;
import com.jarry.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/8
 * @describe 商品类别
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {


    @Autowired
    TbItemCatMapper tbItemCatMapper;

    /**
     * 获取商品类别列表
     *
     * @param parentId
     * @return
     */
    public List<TbItemCat> getTbItemCategoryList(long parentId) {

        TbItemCat tbItemCat = new TbItemCat();
        tbItemCat.setParentId(parentId);
        return tbItemCatMapper.selectByCondition(tbItemCat);
    }

    /**
     * 获取商品类别
     * @param id
     * @return
     */
    @Override
    public TbItemCat getTbItemCategoryById(Long id) {
        return tbItemCatMapper.selectByPrimaryKey(id);
    }
}
