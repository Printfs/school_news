package com.feifan.service;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface NewService {

    //查询所有
    PageInfo findAll(Integer pn);
    //通过Id查询

    ServletResponse<News> getById(Integer newsId);
//    public ServletResponse get();
    ServletResponse publishNews(News news);

    //查询所有新闻列表
   ServletResponse<List<News>> getAllList();

    News findById(Integer newsId);

    //查询Like新闻
    PageInfo findAllByLike(String key,Integer pn);

  //根据新闻分类查询新闻
    PageInfo findAllByParentId(Integer parentId, Integer pn);

}
