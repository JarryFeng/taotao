package com.jarry.mapper;

import com.jarry.pojo.TbOrderShipping;

import java.util.List;

public interface TbOrderShippingMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShipping record);

    TbOrderShipping selectByPrimaryKey(String orderId);

    List<TbOrderShipping> selectAll();

    int updateByPrimaryKey(TbOrderShipping record);
}