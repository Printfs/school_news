package com.feifan.service;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;

import java.util.List;

public interface NewService {

    //查询所有
    ServletResponse getAll(Integer pn);
    //通过Id查询
    ServletResponse<News> getById(Integer newsId);
//    public ServletResponse get();
    ServletResponse publishNews(News news);

    //查询所有新闻列表
   ServletResponse<List<News>> getAllList();
}
