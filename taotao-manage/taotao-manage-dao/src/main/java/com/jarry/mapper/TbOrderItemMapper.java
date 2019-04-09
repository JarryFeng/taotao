package com.jarry.mapper;

import com.jarry.pojo.TbOrderItem;

import java.util.List;

public interface TbOrderItemMapper {
    int insert(TbOrderItem record);

    List<TbOrderItem> selectAll();
}