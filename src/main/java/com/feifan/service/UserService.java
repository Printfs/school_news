package com.feifan.service;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.User;


public interface UserService {
    ServletResponse load(User user);

    ServletResponse updateuser(User user);

    ServletResponse<User> findAll(String email);
}
