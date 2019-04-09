package com.jarry.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jarry.easyui.pojo.EasyUIGridResult;
import com.jarry.mapper.TbItemMapper;
import com.jarry.pojo.TbItem;
import com.jarry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return tbItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<TbItem> showTbItemList(int pageSize, int pageNo) {
        PageHelper.startPage(pageNo, pageSize);

        List<TbItem> tbItems = tbItemMapper.selectAll();

        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);

        return pageInfo;
    }

}
