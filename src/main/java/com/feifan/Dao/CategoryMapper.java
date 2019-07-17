package com.feifan.Dao;

import com.feifan.Common.ServletResponse;
import com.feifan.Pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {

   //添加分类
    public ServletResponse addType(@Param("kinds") String kinds);


}
