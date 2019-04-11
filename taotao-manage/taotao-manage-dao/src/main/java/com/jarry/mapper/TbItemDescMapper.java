package com.jarry.mapper;

import com.jarry.pojo.TbItemDesc;

import java.util.List;

public interface TbItemDescMapper {
    int insert(TbItemDesc record);

    List<TbItemDesc> selectAll();

    TbItemDesc selectByItemId(Long itemId);
}