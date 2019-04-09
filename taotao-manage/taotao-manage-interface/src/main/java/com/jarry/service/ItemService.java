package com.jarry.service;

import com.github.pagehelper.PageInfo;
import com.jarry.pojo.TbItem;

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

}
