package com.feifan.controller;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.User;
import com.feifan.security.JwtUtil;
import com.feifan.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    public UserServiceImpl userService;

    //    登陆
    @RequestMapping(value = "/load", method = RequestMethod.GET)
    public ServletResponse userload(User user) {

        if (user != null) {
            //查询
            ServletResponse response = userService.load(user);

            if (response != null) {
                //将email作为唯一标识
                String token = JwtUtil.getToken(user.getEmail());
                return ServletResponse.createBySuccess("已缓存", token);
            }

            return ServletResponse.createByErrorMessage("登陆失败");
        }
        return ServletResponse.createByErrorMessage("输入参数有误");

    }


    @RequestMapping(value = "/update", method = RequestMethod.GET)
//    public ServletResponse userupdate(User user,String key) {
    public ServletResponse userupdate(String name,String password,String publisher,String email,String key) {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setPublisher(publisher);
        user.setEmail(email);
//        System.out.println(user);

        String useremail = JwtUtil.getUsername(key);

        if (useremail != null && user.getEmail().equals(useremail)){

           return userService.updateuser(user);
        }

        return ServletResponse.createByErrorMessage("信息匹配错误");
    }

    /*
    查询个人信息
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ServletResponse<User> userfind(String key) {
        String useremail = JwtUtil.getUsername(key);

        if (useremail != null) {
            ServletResponse<User> all = userService.findAll(useremail);
            if (all.getData() != null){
                return all;
            }
            return ServletResponse.createByError();
        }

        return ServletResponse.createByError();
    }
}
