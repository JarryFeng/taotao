package com.jarry.portal.controller;

import com.github.pagehelper.PageInfo;
import com.jarry.content.service.TbContentService;
import com.jarry.pojo.TbContent;
import com.jarry.portal.pojo.ADNode1;
import com.jarry.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fengzheng
 * @date 2019/4/11
 * @describe
 */
@Controller
public class IndexController {

    @Value("${CENTER_AD_ID}")
    private Long centerAdId;

    @Value("${CENTER_HEIGHT_A}")
    private Integer centerHeightA;

    @Value("${CENTER_HEIGHT_B}")
    private Integer centerHeightB;

    @Value("${CENTER_WIDTH_A}")
    private Integer centerWidthA;

    @Value("${CENTER_WIDTH_B}")
    private Integer centerWidthB;

    @Autowired
    TbContentService tbContentService;

    @RequestMapping("/index")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<TbContent> contentList = tbContentService.getContentList(centerAdId, 100, 1);

        List<TbContent> list = contentList.getList();
        List<ADNode1> adList = new ArrayList<>();
        for (int i = 0; i< list.size(); i++){
            TbContent tbContent = list.get(i);
            ADNode1 adNode1 = new ADNode1();
            adNode1.setAlt(tbContent.getContent());
            adNode1.setHref(tbContent.getUrl());
            adNode1.setSrc(tbContent.getPic());
            adNode1.setHeight(centerHeightA);
            adNode1.setWidth(centerWidthA);

            adNode1.setSrcB(tbContent.getPic2());
            adNode1.setHeightB(centerHeightB);
            adNode1.setWidthB(centerWidthB);

            adList.add(adNode1);
        }
        modelAndView.addObject("ad1", JsonUtils.objectToJson(adList));
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
