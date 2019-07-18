package com.feifan.controller;


import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;
import com.feifan.service.impl.NewsServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin    //跨域
@RestController
@RequestMapping("/News/")
public class NewsCtroller {

    @Resource
    NewsServiceImpl newsService;

    @RequestMapping("selectAll.do")
    public ServletResponse<List<News>> tt(){

        return newsService.get();
    }

//    @RequestMapping("test.do")
//    public ServletResponse test(){
//        News news = new News();
//        news.setNewsId(1);
//        news.setContents("测试");
//        return ServletResponse.creatBySuccess(news);
//    }
}
