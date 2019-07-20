package com.feifan.dao;

import com.feifan.pojo.News;
import com.feifan.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TypeMapper {
    //查询所有的Type记录
    List<Type> findAll();


    //通过parentId 查新闻
    List<News> findAllByParentId(Integer parentId);
}
