package com.feifan.controller;


import com.feifan.common.ServletResponse;

import com.feifan.security.JwtUtil;
import com.feifan.service.impl.ManageFuzzySearchServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@CrossOrigin
@RequestMapping("/back/")
public class ManageFuzzySearchController {

    @Resource
    ManageFuzzySearchServiceImpl mfss;

    @RequestMapping("fuzzySearchNews.do")
    @ResponseBody
    public ServletResponse<PageInfo> like_search_news(String text,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                                      String key) {


        if (text == null) {
            return ServletResponse.createByErrorMessage("输入信息有误");
        }

        //检查
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null) {
            return mfss.VoNews(pageNum, pageSize, text);
        }

        return ServletResponse.createByError();


    }

    @RequestMapping("fuzzySearchNotice.do")
    @ResponseBody
    public ServletResponse<PageInfo> like_search_notice(String text,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                                        String key) {


        if (text == null) {
            return ServletResponse.createByErrorMessage("输入信息有误");
        }
        //检查
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null) {
            return mfss.VoNotice(pageNum, pageSize, text);
        }

        return ServletResponse.createByError();


    }
}
