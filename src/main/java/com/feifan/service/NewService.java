package com.feifan.service;

import com.feifan.pojo.News;
import com.github.pagehelper.PageInfo;

public interface NewService {

    //查询所有
    PageInfo findAll(Integer pn);
    //通过Id查询
    News findById(Integer newsId);
    //查询Like新闻
    PageInfo findAllByLike(String key,Integer pn);
}
