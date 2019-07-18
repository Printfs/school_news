package com.feifan.dao;


import com.feifan.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //添加分类
    public Integer addType(@Param("kinds") String kinds);

    //查询分类
    public List<Type> selectAllCategory();


    public Integer delteCategory(@Param("kinds") String kinds);

    //修改
    Integer updateCategory(@Param("oldkinds") String oldkinds,@Param("newkinds") String newkinds);

}
