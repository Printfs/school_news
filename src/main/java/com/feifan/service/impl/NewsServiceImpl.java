package com.feifan.service.impl;


import com.feifan.common.ServletResponse;
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

    public ServletResponse getAll(Integer pn){
        PageHelper.startPage(pn,5);
        List<News> news = newsMapper.getAll();
        PageInfo pageInfo = new PageInfo(news, 5);
        return ServletResponse.createBySuccess(pageInfo);
    }

    public ServletResponse<News> getById(Integer newsId) {
        News news = newsMapper.getById(newsId);
        return ServletResponse.createBySuccess(news);
    }
}
