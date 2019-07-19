package com.feifan.service.impl;


import com.feifan.dao.NewsMapper;
import com.feifan.pojo.News;
import com.feifan.service.NewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl implements NewService {

    @Resource
    NewsMapper newsMapper;

    @Override
    public PageInfo findAll(Integer pn){
        PageHelper.startPage(pn,5);
        List<News> news = newsMapper.findAll();
        PageInfo pageInfo = new PageInfo(news, 5);
        return pageInfo;
    }

    @Override
    public News findById(Integer newsId) {
        News news = newsMapper.findById(newsId);
        return news;
    }

    @Override
    public PageInfo findAllByParentId(Integer parentId, Integer pn) {
        PageHelper.startPage(pn,5);
        List<News> news = newsMapper.findAllByParentId(parentId);
        PageInfo pageInfo = new PageInfo(news, 5);
        return pageInfo;
    }
}
