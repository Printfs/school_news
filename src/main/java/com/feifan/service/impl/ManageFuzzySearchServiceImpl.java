package com.feifan.service.impl;

import com.feifan.common.ServletResponse;
import com.feifan.dao.NewsMangeMapper;
import com.feifan.dao.NoticeMapper;
import com.feifan.pojo.News;
import com.feifan.pojo.Notice;
import com.feifan.service.ManageFuzzySearchService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
    组装 公告和新闻
*/

@Service
public class ManageFuzzySearchServiceImpl implements ManageFuzzySearchService {


    //引入noticeMapper
    @Resource
    public NoticeMapper noticeMapper;
    //引入newMapper
    @Resource
    public NewsMangeMapper newsMangeMapper;


    //新闻
    public ServletResponse<PageInfo> VoNews(int pageNum, int pageSize, String newstext) {

        PageHelper.startPage(pageNum, pageSize);


        //得到新闻
        List<News> news = newsMangeMapper.likeNews(newstext);

        if (news != null) {
            PageInfo pageInfo = new PageInfo(news);
            return ServletResponse.createBySuccess(pageInfo);
        }

        return ServletResponse.createByErrorMessage("没有找到");

    }

    //公告
    //得到公告
    public ServletResponse<PageInfo> VoNotice(int pageNum, int pageSize, String noticetext) {

        PageHelper.startPage(pageNum, pageSize);



        List<Notice> notices = noticeMapper.likeNotice(noticetext);
        if (notices != null) {
            PageInfo pageInfo = new PageInfo(notices);
            //        pageInfo.setList(list);

            return ServletResponse.createBySuccess(pageInfo);
        }


        return ServletResponse.createByErrorMessage("没有找到");
    }



}
