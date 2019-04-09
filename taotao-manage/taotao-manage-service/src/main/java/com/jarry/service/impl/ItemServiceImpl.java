package com.jarry.service.impl;

import com.jarry.mapper.TbItemMapper;
import com.jarry.pojo.TbItem;
import com.jarry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fengzheng
 * @date 2019/4/8
 * @describe
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    TbItemMapper tbItemMapper;

    @Override
    public TbItem getTbItemById(long id) {
        System.out.println("hello world222222222");
        return tbItemMapper.selectByPrimaryKey(id);
    }
}
