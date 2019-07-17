package com.feifan.Controller;


import com.feifan.Common.ServletResponse;
import com.feifan.Service.NewsServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin    //跨域
@RestController
@RequestMapping("/News/")
public class NewsCtroller {

    @Resource
    NewsServiceImpl newsService;

    @RequestMapping("selectAll.do")
    public ServletResponse tt(){
        return newsService.get();
    }

//    @RequestMapping("test.do")
//    public String test(String text){
//        System.out.println(text);
//        return text;
//    }
}
