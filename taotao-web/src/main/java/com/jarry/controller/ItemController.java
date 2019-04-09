package com.jarry.controller;

import com.github.pagehelper.PageInfo;
import com.jarry.easyui.pojo.EasyUIGridResult;
import com.jarry.pojo.TbItem;
import com.jarry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/8
 * @describe 商品管理
 */
@Controller
public class ItemController {

    @Autowired
    ItemService itemSerivce;

    /**
     * 获取商品信息
     *
     * @param itemId
     * @return
     */
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        return itemSerivce.getTbItemById(itemId);
    }


    /**
     * 商品列表
     *
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIGridResult showTbItemList(@RequestParam int rows, int page) {

        PageInfo<TbItem> pageInfo = itemSerivce.showTbItemList(rows, page);

        //封装成easyui需要的json格式
        EasyUIGridResult easyUIGridResult = new EasyUIGridResult();
        easyUIGridResult.setRows(pageInfo.getList());
        easyUIGridResult.setTotal(pageInfo.getTotal());
        return easyUIGridResult;
    }
}
