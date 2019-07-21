package com.feifan.dao;

import com.feifan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    Integer checkEmail(String email);
    /**
     * 登录
     */
    Integer load(User user);

    /**
     * 修改用户信息
     */
    Integer updateuser(User user);

    /**
     * 查询所有用户
     * @return
     */
    User findAll(String email);


    User select_by_email(@Param("email") String email);
}
