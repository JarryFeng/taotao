package com.jarry.controller;

import com.github.pagehelper.PageInfo;
import com.jarry.content.service.TbContentService;
import com.jarry.easyui.pojo.EasyUIGridResult;
import com.jarry.easyui.pojo.EasyUITreeNode;
import com.jarry.easyui.pojo.TaotaoResult;
import com.jarry.pojo.TbContent;
import com.jarry.pojo.TbContentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/12
 * @describe
 */
@Controller
public class ContentController {

    @Autowired
    TbContentService tbContentService;

    /**
     * 内容分类
     *
     * @return
     */
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getTbItemCategoryList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {
        List<TbContentCategory> tbContentCategoryList = tbContentService.getContentCategoryList(parentId);

        //封装成easyui需要的json格式
        List<EasyUITreeNode> list = new ArrayList<>();
        for (int i = 0; tbContentCategoryList != null && i < tbContentCategoryList.size(); i++) {

            TbContentCategory TbContentCategory = tbContentCategoryList.get(i);

            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(TbContentCategory.getId());
            easyUITreeNode.setText(TbContentCategory.getName());
            easyUITreeNode.setState(TbContentCategory.getIsParent() ? "closed" : "open");
            list.add(easyUITreeNode);
        }

        return list;
    }

    /**
     * 添加内容分类
     *
     * @param parentId
     * @param name
     * @return
     */
    @RequestMapping(value = "/content/category/create", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createCategory(Long parentId, String name) {

        TbContentCategory tcc = tbContentService.saveContentCategory(parentId, name);

        return TaotaoResult.ok(tcc);
    }

    /**
     * 删除内容分类
     *
     * @param parentId
     * @param id
     * @return
     */
    @RequestMapping(value = "/content/category/delete", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createCategory(Long parentId, Long id) {

        int i = tbContentService.deleteContentCategory(parentId, id);
        System.out.println("总共删除" + i + "节点");
        return TaotaoResult.ok();
    }


    /**
     * 修改内容分类
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/content/category/update", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateCategory(Long id, String name) {

        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(id);
        tbContentCategory.setName(name);
        tbContentService.updateContentCategory(tbContentCategory);

        return TaotaoResult.ok();
    }


    /**
     * 内容列表
     *
     * @return
     */
    @RequestMapping("/content/query/list")
    @ResponseBody
    public EasyUIGridResult getTbContentList(Long categoryId, int rows, int page) {

        PageInfo<TbContent> pageInfo = tbContentService.getContentList(categoryId, rows, page);

        //封装成easyui需要的json格式
        EasyUIGridResult easyUIGridResult = new EasyUIGridResult();
        easyUIGridResult.setRows(pageInfo.getList());
        easyUIGridResult.setTotal(pageInfo.getTotal());
        return easyUIGridResult;
    }
}
