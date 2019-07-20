package com.feifan.controller;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.Type;
import com.feifan.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
