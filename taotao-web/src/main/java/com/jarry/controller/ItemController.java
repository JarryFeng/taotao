package com.jarry.controller;

import com.github.pagehelper.PageInfo;
import com.jarry.easyui.pojo.EasyUIGridResult;
import com.jarry.easyui.pojo.TaotaoResult;
import com.jarry.pojo.TbItem;
import com.jarry.pojo.TbItemDesc;
import com.jarry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 添加商品信息
     *
     * @param tbItem
     * @return
     */
    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult addTbItem(TbItem tbItem, String desc) {
        itemSerivce.addTbItem(tbItem, desc);

        return TaotaoResult.ok();
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

    @RequestMapping("/itemdesc/{id}")
    @ResponseBody
    public TaotaoResult getTbItemDesc(@PathVariable Long id) {
        TbItemDesc tbItemDesc = itemSerivce.getTbItemDescById(id);
        return TaotaoResult.ok(tbItemDesc);
    }
}
