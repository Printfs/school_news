package com.feifan.Dao;

import com.feifan.Pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {

    List<News> getall();
}
