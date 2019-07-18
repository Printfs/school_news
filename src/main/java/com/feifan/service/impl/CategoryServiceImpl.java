package com.feifan.service.impl;


import com.feifan.common.ServletResponse;
import com.feifan.dao.CategoryMapper;
import com.feifan.pojo.Type;

import com.feifan.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    /*
    添加节点
     */
    public ServletResponse add_type(String kinds) {
        if (!StringUtils.isEmpty(kinds)) {
            Integer integer = categoryMapper.addType(kinds);
            if (integer != 0) {
                return ServletResponse.createBySuccessMessage("插入节点成功");
            }
        }

        return ServletResponse.createByErrorMessage("插入节点失败");
    }

   /*
   查看所有节点

    */

   public ServletResponse getCategory(){

       List<Type> types = categoryMapper.selectAllCategory();
       if(types == null){

       }
       return null;
   }



}
