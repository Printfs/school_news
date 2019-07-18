package com.feifan.dao;

import com.feifan.common.ServletResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {

   //添加分类
    public ServletResponse addType(@Param("kinds") String kinds);


}
