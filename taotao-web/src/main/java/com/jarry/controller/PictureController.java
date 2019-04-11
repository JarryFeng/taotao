package com.jarry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fengzheng
 * @date 2019/4/11
 * @describe 图片上传
 * <p>
 * 成功时
 * {"error":0, "url":"xxxxx"}
 * 失败时
 * {"error":1,"message":"错误信息"}
 */
@Controller
public class PictureController {

    @RequestMapping("/pic/upload")
    @ResponseBody
    public Map upload(MultipartFile uploadFile, HttpServletRequest request) {

        //获取项目路径，例如：G:\projects\taotao\taotao-web\target\taotao-web
        //request.getSession().getServletContext().getRealPath("");
        //获取项目路径，例如：G:\projects\taotao\taotao-web\target\taotao-web\
        //request.getSession().getServletContext().getRealPath("/");

        Map map = new HashMap<>();

        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            //将图片放入本地服务器images
            inputStream = uploadFile.getInputStream();
            //获取原始文件名
            String filename = uploadFile.getOriginalFilename();
            fos = new FileOutputStream(new File(request.getSession().getServletContext().getRealPath("/") + "images/" + filename));
            int read = 0;
            while ((read = inputStream.read()) != -1) {
                fos.write(read);
            }

            map.put("error", 0);
            map.put("url", "/images/" + filename);
        } catch (Exception e) {
            map.put("error", 1);
            map.put("message", e.getMessage());
        } finally {
            try {
                if(fos != null) {
                    fos.close();
                }
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return map;
    }
}
