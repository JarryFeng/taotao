package com.jarry.service;

import com.github.pagehelper.PageInfo;
import com.jarry.pojo.TbItem;
import com.jarry.pojo.TbItemDesc;

/**
 * @author fengzheng
 * @date 2019/4/8
 * @describe
 */
public interface ItemService {

    TbItem getTbItemById(long id);

    /**
     * 获取商品列表
     *
     * @param pageSize
     * @param pageNo
     * @return
     */
    PageInfo<TbItem> showTbItemList(int pageSize, int pageNo);

    /**
     * 添加商品
     * @param tbItem
     * @return
     */
    void addTbItem(TbItem tbItem, String desc);

    /**
     * 获取商品描述
     * @param id
     * @return
     */
    TbItemDesc getTbItemDescById(Long id);
}
