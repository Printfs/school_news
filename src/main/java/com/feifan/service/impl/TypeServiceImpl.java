package com.feifan.service.impl;

import com.feifan.dao.TypeMapper;
import com.feifan.pojo.News;
import com.feifan.pojo.Type;
import com.feifan.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo findAllByParentId(Integer parentId, Integer pn) {
        PageHelper.startPage(pn,5);
        List<News> news = typeMapper.findAllByParentId(parentId);
        PageInfo pageInfo = new PageInfo(news, 5);
        return pageInfo;
    }

}
