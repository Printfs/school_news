package com.feifan.Service;


import com.feifan.Common.ServletResponse;
import com.feifan.Dao.NewsMapper;
import com.feifan.Pojo.News;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NewsServiceImpl {

    @Resource
    NewsMapper newsMapper;

    public ServletResponse get(){
        List<News> getall = newsMapper.getall();
        return ServletResponse.creatBySuccess(getall);
    }

}
