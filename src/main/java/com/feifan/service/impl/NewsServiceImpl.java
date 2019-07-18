package com.feifan.service.impl;


import com.feifan.common.ServletResponse;
import com.feifan.dao.NewsMapper;
import com.feifan.pojo.News;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl {

    @Resource
    NewsMapper newsMapper;

    public ServletResponse get(){
        List<News> getall = newsMapper.getall();
        return ServletResponse.createBySuccess(getall);
    }

}
