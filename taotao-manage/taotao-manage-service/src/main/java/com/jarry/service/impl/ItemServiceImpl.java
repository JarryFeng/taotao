package com.jarry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jarry.mapper.TbItemDescMapper;
import com.jarry.mapper.TbItemMapper;
import com.jarry.myenum.StatusEnum;
import com.jarry.pojo.TbItem;
import com.jarry.pojo.TbItemDesc;
import com.jarry.service.ItemService;
import com.jarry.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    TbItemDescMapper tbItemDescMapper;

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

    @Override
    public void addTbItem(TbItem tbItem, String desc) {

        //添加商品信息
        long id = IDUtils.genItemId();
        tbItem.setId(id);
        tbItem.setStatus(StatusEnum.正常.getCode());
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        tbItemMapper.insert(tbItem);

        //添加商品描述
        TbItemDesc tbItemDesc = new TbItemDesc();
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setItemId(id);
        tbItemDesc.setCreated(new Date());
        tbItemDesc.setUpdated(new Date());
        tbItemDescMapper.insert(tbItemDesc);
    }

    @Override
    public TbItemDesc getTbItemDescById(Long id) {
        return tbItemDescMapper.selectByItemId(id);
    }

}
