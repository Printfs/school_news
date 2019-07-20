package com.feifan.service.impl;

import com.feifan.common.ServletResponse;
import com.feifan.dao.NoticeMapper;
import com.feifan.pojo.Notice;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class NoticeServiceImpl {

    @Resource
    NoticeMapper noticeMapper;

    /*
    发布公告
     */
    public ServletResponse publish_notice(Notice notice){
        if (notice != null){
            Integer integer = noticeMapper.publishNotice(notice);
            if (integer != null){
                return ServletResponse.createBySuccessMessage("公告发布成功");
            }
        }

        return ServletResponse.createByErrorMessage("公告发布失败");
    }

    /*
    查询公告
     */
    public ServletResponse select_notice(){
        List<Notice> notices = noticeMapper.selectAll();
        if(!CollectionUtils.isEmpty(notices)){
            return ServletResponse.createBySuccess(notices);
        }
        return ServletResponse.createByErrorMessage("查询失败");
    }

}
