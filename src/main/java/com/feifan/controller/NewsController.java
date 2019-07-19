package com.feifan.controller;


import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;
import com.feifan.service.impl.NewsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin    //跨域
@RestController
@RequestMapping("/news/")
public class NewsController {

    @Resource
    NewsServiceImpl newsService;

    /**
     * 查询数据
     * @return
     */
    @GetMapping("")
    public ServletResponse<List<News>> findAll(@RequestParam(name = "pn",defaultValue = "1")Integer pn){
        return newsService.getAll(pn);
    }

    /**
     * 通过Id查询数据
     */
    @GetMapping("/{newsId}")
    public ServletResponse<News> findById(@PathVariable(name = "newsId") Integer newsId){
        return newsService.getById(newsId);
    }


}
