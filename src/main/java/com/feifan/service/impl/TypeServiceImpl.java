package com.feifan.service.impl;

import com.feifan.dao.TypeMapper;
import com.feifan.pojo.Type;
import com.feifan.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    TypeMapper typeMapper;

    @Override
    public List<Type> findAll() {
        List<Type> types = typeMapper.findAll();
        return types;
    }

}
