package com.jarry.mapper;

import com.jarry.pojo.TbCart;

import java.util.List;

public interface TbCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbCart record);

    TbCart selectByPrimaryKey(Long id);

    List<TbCart> selectAll();

    int updateByPrimaryKey(TbCart record);
}