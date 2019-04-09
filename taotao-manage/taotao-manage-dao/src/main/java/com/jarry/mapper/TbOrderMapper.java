package com.jarry.mapper;

import com.jarry.pojo.TbOrder;

import java.util.List;

public interface TbOrderMapper {
    int insert(TbOrder record);

    List<TbOrder> selectAll();
}