package com.jarry.mapper;

import com.jarry.pojo.TbItem;

import java.util.List;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    List<TbItem> selectAll();

    int updateByPrimaryKey(TbItem record);
}