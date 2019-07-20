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

    List<News> getAll();

    //通过Id查询新闻
    News getById(Integer newsId);

   // List<News> fuzzySearch(@Param("keyword") String keyword);

    //发布新闻，返回影响的行数
    public int publishNews(News news);


    List<News> findAll();

    //通过newsId查询新闻
    News findById(Integer newsId);

    //通过parentId 查新闻
    List<News> findAllByParentId(Integer parentId);
}
