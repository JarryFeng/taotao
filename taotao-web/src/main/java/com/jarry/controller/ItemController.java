package com.jarry.controller;

import com.jarry.pojo.TbItem;
import com.jarry.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
     * @param itemId
     * @return
     */
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        return itemSerivce.getTbItemById(itemId);
    }
}
