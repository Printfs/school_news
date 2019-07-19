package com.feifan.controller;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.Notice;
import com.feifan.service.impl.NoticeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@CrossOrigin
@Controller
@RequestMapping("/notice/")
public class NoticeController {

    @Resource
    NoticeServiceImpl noticeServiceimpl;
    /*
    发布公告
     */
    @RequestMapping("/publish.do")
    @ResponseBody
    public ServletResponse publish_notice(Notice notice, HttpSession session){
        Object user = session.getAttribute("user");

        return noticeServiceimpl.publish_notice(notice);

    }
    /*
    查询所有公告
     */
    @RequestMapping("/getAll.do")
    @ResponseBody
    public ServletResponse getAll_notice(Notice notice, HttpSession session){
        Object user = session.getAttribute("user");

        return noticeServiceimpl.select_notice();

    }
    /*
    删除公告
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public ServletResponse delete_notice(Notice notice, HttpSession session){
        Object user = session.getAttribute("user");

        return noticeServiceimpl.publish_notice(notice);

    }






}
