package com.jarry.mapper;

import com.jarry.pojo.TbUser;

import java.util.List;

public interface TbUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    List<TbUser> selectAll();

    int updateByPrimaryKey(TbUser record);
}