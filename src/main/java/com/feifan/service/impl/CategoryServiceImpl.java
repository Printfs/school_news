package com.feifan.service.impl;


import com.feifan.common.ServletResponse;
import com.feifan.dao.CategoryMapper;
import com.feifan.pojo.Type;

import com.feifan.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

   public ServletResponse<PageInfo> getCategory(int pageNum, int pageSize){

       //开始分页
       PageHelper.startPage(pageNum,pageSize);

       List<Type> types = categoryMapper.selectAllCategory();
       if(types == null){
           return ServletResponse.createByErrorMessage("没有节点");
       }
       PageInfo pageInfo=new PageInfo(types);

       return ServletResponse.createBySuccess(pageInfo);
   }

   /*
   删除节点
    */

    public ServletResponse delete_type(String kinds) {
        if (!StringUtils.isEmpty(kinds)) {
            Integer integer = categoryMapper.delteCategory(kinds);
            if (integer != 0) {
                return ServletResponse.createBySuccessMessage("删除节点成功");
            }
        }
        return ServletResponse.createByErrorMessage("删除节点失败");
    }

    /*
    更新节点
     */
    public ServletResponse update_type(String oldkinds,String newkinds) {
        if (!(StringUtils.isEmpty(oldkinds) && StringUtils.isEmpty(newkinds)) ) {
            Integer integer = categoryMapper.updateCategory(oldkinds,newkinds);
            if (integer != 0) {
                return ServletResponse.createBySuccessMessage("修改节点成功");
            }
        }
        return ServletResponse.createByErrorMessage("修改节点失败");
    }





}
