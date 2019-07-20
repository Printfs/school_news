package com.feifan.controller;


import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;
import com.feifan.service.impl.NewsServiceImpl;

import com.mysql.jdbc.util.ResultSetUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin    //跨域
@RestController
@RequestMapping("/news")
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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


    /*发布新闻*/
    @PostMapping("/editor.do")
    public ServletResponse<News> getContent(String text,String title,String author,String publish){
        if(!StringUtils.isEmpty(title)&&!StringUtils.isEmpty(text)){
            News news = new News();
            news.setTitle(title);
            news.setAuthor(author);
            news.setPublisher(publish);
            news.setContent(text);
            news.setPublishTime(LocalDateTime.now().toString());
            news.setParentId(2);
            return newsService.publishNews(news);
        }

        return ServletResponse.createByErrorMessage("发布失败!");

    }

    /*显示新闻列表*/
    @PostMapping("/list")
    public ServletResponse getAllNews(){
        ServletResponse<List<News>> allList = newsService.getAllList();
        System.out.println(allList);


        return null ;
    }


}
