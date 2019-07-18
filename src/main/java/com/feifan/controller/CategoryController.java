package com.feifan.controller;


import com.feifan.common.ServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("/category/")
public class CategoryController {


    @RequestMapping("addType")
    public ServletResponse add_type(String kinds, HttpSession session){
        Object user = session.getAttribute("user");
        //检查user身份

     return null;
    }


}
