package com.jarry.service;

import com.jarry.pojo.TbItemCat;

import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/8
 * @describe 商品类别
 */
public interface ItemCategoryService {

    /**
     * 获取商品类别列表
     *
     * @param parentId
     * @return
     */
    List<TbItemCat> getTbItemCategoryList(long parentId);

    TbItemCat getTbItemCategoryById(Long id);
}
