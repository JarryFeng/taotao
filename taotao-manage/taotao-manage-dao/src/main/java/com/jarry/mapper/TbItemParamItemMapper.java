package com.jarry.mapper;

import com.jarry.pojo.TbItemParamItem;

import java.util.List;

public interface TbItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    TbItemParamItem selectByPrimaryKey(Long id);

    List<TbItemParamItem> selectAll();

    int updateByPrimaryKey(TbItemParamItem record);
}