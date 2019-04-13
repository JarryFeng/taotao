package com.jarry.mapper;

import com.jarry.pojo.TbContentCategory;

import java.util.List;

public interface TbContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbContentCategory record);

    TbContentCategory selectByPrimaryKey(Long id);

    List<TbContentCategory> selectAll();

    int updateByPrimaryKey(TbContentCategory record);

    List<TbContentCategory> selectByCondition(TbContentCategory tbContentCategory);
}