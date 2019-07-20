package com.feifan.controller;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.Type;
import com.feifan.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin    //跨域
@RestController
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/type")
    public ServletResponse<List<Type>> findAllType(){
        return ServletResponse.createBySuccess(typeService.findAll());
    }

    /**
     * 根据 新闻分类查询新闻
     */
    @GetMapping("/type/{parentId}")
    public ServletResponse<PageInfo> findAllByParentId(@PathVariable(name = "parentId")Integer parentId,
                                                       @RequestParam(name = "pn",defaultValue = "1")Integer pn){
        return ServletResponse.createBySuccess(typeService.findAllByParentId(parentId,pn));
    }

}
