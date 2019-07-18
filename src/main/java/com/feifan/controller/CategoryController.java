package com.feifan.controller;



import com.feifan.common.ServletResponse;
import com.feifan.service.impl.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("/category/")
public class CategoryController {

    @Resource
    CategoryServiceImpl categoryService;


    @RequestMapping("addType.do")
    @ResponseBody
    public ServletResponse add_type(String kinds, HttpSession session){
        Object user = session.getAttribute("user");
        //检查user身份

     return categoryService.add_type(kinds);
    }




}
