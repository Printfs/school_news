package com.feifan.controller;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.Notice;
import com.feifan.pojo.User;
import com.feifan.service.impl.NoticeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

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
    public ServletResponse publish_notice(String title, String text, HttpSession session) {
//        Object user = session.getAttribute("user");
        User user = new User();
        user.setName("任航");
        user.setPassword("123456");
        user.setPublisher("政教处");
        user.setStatus(2);
        if (!(StringUtils.isEmpty(title) && StringUtils.isEmpty(text))) {
            //组装notice
            Notice notice = new Notice();
            notice.setTitle(title);
            notice.setContent(text);
            notice.setPublishTime(LocalDate.now().toString());
            notice.setPublisher(user.getPublisher());


            return  noticeServiceimpl.publish_notice(notice);
        }

        return ServletResponse.createByErrorMessage("发布失败");

    }

    /*
    查询所有公告
     */
    @RequestMapping("getAll.do")
    @ResponseBody
    public ServletResponse getAll_notice(HttpSession session) {
        Object user = session.getAttribute("user");

        return noticeServiceimpl.select_notice();

    }

    /*
    删除公告
     */
    @RequestMapping("/delete.do")
    @ResponseBody
    public ServletResponse delete_notice(Notice notice, HttpSession session) {
        Object user = session.getAttribute("user");

        return noticeServiceimpl.publish_notice(notice);

    }


}
