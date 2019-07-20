package com.feifan.service.impl;


import com.feifan.common.ServletResponse;
import com.feifan.dao.NewsMapper;
import com.feifan.pojo.News;

import com.feifan.service.NewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class NewsServiceImpl implements NewService {

    @Resource
    NewsMapper newsMapper;

    // Updated upstream
    public ServletResponse getAll(Integer pn) {
        PageHelper.startPage(pn, 5);
        List<News> news = newsMapper.getAll();
        PageInfo pageInfo = new PageInfo(news, 5);
        return ServletResponse.createBySuccess(pageInfo);

    }

//    //模糊查询
//    public ServletResponse<PageInfo> fuzzySearch(int pageNum,int pageSize,String keyword){
//        //开始分页
//        PageHelper.startPage(pageNum,pageSize);
//
//        //查询
//
//
//       return null;
////Stashed changes
//    }

    public ServletResponse<News> getById(Integer newsId) {
        News news = newsMapper.getById(newsId);
        return ServletResponse.createBySuccess(news);
    }


    @Override
    public ServletResponse publishNews(News news) {
        if(news!=null){
            int n = newsMapper.publishNews(news);
            if(n>0){
                return ServletResponse.createBySuccessMessage("新闻发布成功!");
            }

        }

        return ServletResponse.createByErrorMessage("新闻发布失败!");

    }


    //查询所有新闻
    @Override
    public ServletResponse<List<News>> getAllList() {
        List<News> newsList = newsMapper.getAll();
        if(!CollectionUtils.isEmpty(newsList)){
            return ServletResponse.createBySuccess(newsList);
        }
        return ServletResponse.createByErrorMessage("没有记录");
    }

}
