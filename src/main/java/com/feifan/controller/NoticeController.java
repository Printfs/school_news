package com.feifan.controller;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.Notice;
import com.feifan.pojo.User;
import com.feifan.security.JwtUtil;
import com.feifan.service.impl.NoticeServiceImpl;
import com.feifan.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Resource
    UserServiceImpl userServiceimpl;

    /*
    发布公告
     */
    @RequestMapping("/publish.do")
    @ResponseBody
    public ServletResponse publish_notice(String title, String text,String key) {

        String email = JwtUtil.getUsername(key);

        User user = userServiceimpl.selectByEmail(email);
//        System.out.println(title+"  "+text);

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
    public ServletResponse<PageInfo> getAll_notice(String key,
                                                   @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                   @RequestParam(value = "pageSize",defaultValue = "5") int pageSize) {
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null){
            return noticeServiceimpl.select_notice(pageNum,pageSize);
        }

       return ServletResponse.createByError();
    }

    /*
    删除公告
     */
    @RequestMapping("delete.do")
    @ResponseBody
    public ServletResponse delete_notice(Integer noticeId, String key) {
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null){
            return noticeServiceimpl.deleteNotice(noticeId);
        }

        return ServletResponse.createByError();

    }


}
