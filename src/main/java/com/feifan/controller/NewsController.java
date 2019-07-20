package com.feifan.controller;


import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;
import com.feifan.service.impl.NewsServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin    //跨域
@RestController
public class NewsController {

    @Resource
    NewsServiceImpl newsService;

    /**
     * 查询数据
     * @return
     */
    @GetMapping("/news")
    public ServletResponse<PageInfo> findAll(@RequestParam(name = "pn",defaultValue = "1")Integer pn){
        return ServletResponse.createBySuccess(newsService.findAll(pn));
    }

    /**
     * 通过Id查询数据
     */
    @GetMapping("/news/{newsId}")
    public ServletResponse<News> findById(@PathVariable(name = "newsId") Integer newsId){
        return ServletResponse.createBySuccess(newsService.findById(newsId));
    }

    /**
     * 根据 新闻分类查询新闻
     */
    @GetMapping("/news/{parentId}")
    public ServletResponse<PageInfo> findAllByParentId(@PathVariable(name = "parentId")Integer parentId,
                                                    @RequestParam(name = "pn",defaultValue = "1")Integer pn){
        return ServletResponse.createBySuccess(newsService.findAllByParentId(parentId,pn));
    }
}
