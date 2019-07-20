package com.feifan.dao;

import com.feifan.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NewsMapper {

//
    //查询所有
    List<News> findAll();

    //通过newsId查询新闻
    News findById(Integer newsId);

    List<News> findAllByLike(String key);


    // List<News> fuzzySearch(@Param("keyword") String keyword);

}
