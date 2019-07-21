package com.feifan.service.impl;

import com.feifan.common.ServletResponse;
import com.feifan.dao.UserMapper;
import com.feifan.pojo.User;
import com.feifan.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    /*
    登陆双重检查
     */
    @Override
    public ServletResponse load(User user) {
        //检查email
        Integer checkEmail = userMapper.checkEmail(user.getEmail());
        if (checkEmail != null) {
            //双重检查
            Integer res = userMapper.load(user);
//            System.out.println(res + "---------------");
            if (res == 0) {
                System.out.println(1111);
                return ServletResponse.createByError();

            }
            return ServletResponse.createBySuccess(res);
        }
        return ServletResponse.createByErrorMessage("没有账号");
    }

    @Override
    public ServletResponse updateuser(User user) {

//        User newuser=new User();
//        newuser.setName(user.getName());
//        newuser.setPassword(user.getPassword());
//        newuser.setPublisher(user.getPublisher());
//        newuser.setEmail(user.getEmail());

        Integer updateuser = userMapper.updateuser(user);
        if (updateuser != null){
//            System.out.println("修改成功");
            return ServletResponse.createBySuccessMessage("修改成功");
        }

        return ServletResponse.createByErrorMessage("修改失败");

    }


    @Override
    public ServletResponse<User> findAll(String email) {
        User all = userMapper.findAll(email);
        if (all != null) {
            return ServletResponse.createBySuccess(all);
        }
        return ServletResponse.createByError();

    }

    /*
      根据email查找
       */
    public User selectByEmail(String email) {
        User user = userMapper.select_by_email(email);
        if (user != null) {
            return user;
        }

        return null;
    }
}
