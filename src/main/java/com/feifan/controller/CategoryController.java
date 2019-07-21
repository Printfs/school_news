package com.feifan.controller;


import com.feifan.common.ServletResponse;
import com.feifan.pojo.Type;
import com.feifan.pojo.User;
import com.feifan.security.JwtUtil;
import com.feifan.service.impl.CategoryServiceImpl;
import com.feifan.service.impl.UserServiceImpl;
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

    @Resource
    UserServiceImpl userService;


    @RequestMapping("addType.do")
    @ResponseBody
    public ServletResponse add_type(String kinds, String key, HttpSession session) {
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null){
            return categoryService.add_type(kinds);
        }
       return ServletResponse.createByErrorMessage("没有权限");
    }

    /*
    查询所有节点
     */
    @RequestMapping("getAllType.do")
    @ResponseBody
    public ServletResponse<PageInfo> get_type(String key,
                                              @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        //检查

        String useremail = JwtUtil.getUsername(key);

        System.out.println(useremail+"+++++++++++");
        if (useremail != null) {
            return categoryService.getCategory(pageNum, pageSize);
        }

        return ServletResponse.createByErrorMessage("查找失败");

    }




    @RequestMapping("deleteType.do")
    @ResponseBody
    public ServletResponse delete_type(String kinds,String key) {
        String useremail = JwtUtil.getUsername(key);

        if (useremail != null) {
            return categoryService.delete_type(kinds);
        }

        return ServletResponse.createByErrorMessage("删除失败");
    }

    @RequestMapping("updateType.do")
    @ResponseBody
    public ServletResponse update_type(String oldkinds,String key, String newkinds) {
        String useremail = JwtUtil.getUsername(key);

        if (useremail != null){
            return categoryService.update_type(oldkinds, newkinds);
        }

       return ServletResponse.createByErrorMessage("没有权限");
    }

}
