package com.jarry.mapper;

import com.jarry.pojo.TbContent;

import java.util.List;

public interface TbContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    TbContent selectByPrimaryKey(Long id);

    List<TbContent> selectAll();

    int updateByPrimaryKey(TbContent record);

    List<TbContent> selectByCatagoryId(Long catagoryId);
}