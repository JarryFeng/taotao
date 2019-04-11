package com.jarry.controller;

import com.github.pagehelper.PageInfo;
import com.jarry.easyui.pojo.EasyUIGridResult;
import com.jarry.easyui.pojo.EasyUITreeNode;
import com.jarry.pojo.TbItem;
import com.jarry.pojo.TbItemCat;
import com.jarry.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/8
 * @describe 商品类别
 */
@Controller
public class ItemCategoryController {

    @Autowired
    ItemCategoryService itemCategoryService;


    /**
     * 商品类别
     *
     * @return
     */
    @RequestMapping("itemCategory/list")
    @ResponseBody
    public List<EasyUITreeNode> getTbItemCategoryList(@RequestParam(name="id", defaultValue = "0") Long parentId) {
        List<TbItemCat> tbItemCategoryList = itemCategoryService.getTbItemCategoryList(parentId);

        //封装成easyui需要的json格式
        List<EasyUITreeNode> list = new ArrayList<>();
        for(int i= 0; tbItemCategoryList!=null && i<tbItemCategoryList.size() ; i++){

            TbItemCat tbItemCat = tbItemCategoryList.get(i);

            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setText(tbItemCat.getName());
            easyUITreeNode.setState(tbItemCat.getIsParent()? "closed":"open");
            list.add(easyUITreeNode);
        }

        return list;
    }

    /**
     * 获取商品类别
     *
     * @return
     */
    @RequestMapping("itemCategory/list/{id}")
    @ResponseBody
    public String getTbItemCategoryById(Long id) {
        TbItemCat tbItemCat = itemCategoryService.getTbItemCategoryById(id);
        return tbItemCat.getName();
    }

}
