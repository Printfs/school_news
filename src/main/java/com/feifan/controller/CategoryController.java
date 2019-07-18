package com.feifan.controller;



import com.feifan.common.ServletResponse;
import com.feifan.pojo.Type;
import com.feifan.service.impl.CategoryServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("getAllType.do")
    @ResponseBody
    public ServletResponse<PageInfo> get_type(HttpSession session,
                                              @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "5") int pageSize){
        Object user = session.getAttribute("user");
        //检查user身份

        return categoryService.getCategory(pageNum,pageSize);
    }


    @RequestMapping("deleteType.do")
    @ResponseBody
    public ServletResponse delete_type(String kinds, HttpSession session){
        Object user = session.getAttribute("user");
        //检查user身份

        return categoryService.delete_type(kinds);
    }

    @RequestMapping("updateType.do")
    @ResponseBody
    public ServletResponse update_type(String oldkinds,String newkinds, HttpSession session){
        Object user = session.getAttribute("user");
        //检查user身份

        return categoryService.update_type(oldkinds,newkinds);
    }

}
