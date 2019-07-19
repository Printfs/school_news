package com.feifan.dao;

import com.feifan.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NewsMapper {

    //查询所有
    List<News> findAll();

    //通过newsId查询新闻
    News findById(Integer newsId);

    //通过parentId 查新闻
    List<News> findAllByParentId(Integer parentId);
}
