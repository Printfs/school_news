package com.feifan.dao;

import com.feifan.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsMapper {

    List<News> getall();
}
