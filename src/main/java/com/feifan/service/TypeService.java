package com.feifan.service;

import com.feifan.pojo.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TypeService {
    //查询所有的分类
    List<Type> findAll();

    //根据新闻分类查询新闻
    PageInfo findAllByParentId(Integer parentId, Integer pn);
}
