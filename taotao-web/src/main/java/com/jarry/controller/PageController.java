package com.jarry.controller;

import com.jarry.pojo.TbItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/8
 * @describe 页面展示
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    /**
     * 显示界面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String itemAdd(@PathVariable String page){
        return page;
    }
}
