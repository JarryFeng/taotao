package com.jarry.content.service;

import com.github.pagehelper.PageInfo;
import com.jarry.pojo.TbContent;
import com.jarry.pojo.TbContentCategory;

import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/12
 * @describe 内容管理
 */
public interface TbContentService {

    /**
     * 内容分类列表
     *
     * @param parentId
     * @return
     */
    public List<TbContentCategory> getContentCategoryList(Long parentId);

    /**
     * 添加内容分类
     *
     * @param parentId
     * @param name
     * @return
     */
    TbContentCategory saveContentCategory(Long parentId, String name);


    /**
     * 修改内容分类
     *
     * @param tbContentCategory
     * @return
     */
    int updateContentCategory(TbContentCategory tbContentCategory);

    /**
     * 删除内容分类
     *
     * @param parentId
     * @param id
     * @return
     */
    public int deleteContentCategory(Long parentId, Long id);


    /**
     * 内容列表
     *
     * @param categoryId
     * @param rows
     * @param page
     * @return
     */
    PageInfo<TbContent> getContentList(Long categoryId, int rows, int page);


}
