package com.feifan.service.impl;

import com.feifan.common.ServletResponse;
import com.feifan.dao.NoticeMapper;
import com.feifan.pojo.Notice;
import com.feifan.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    @Resource
    NoticeMapper noticeMapper;

    /*
    发布公告
     */
    public ServletResponse publish_notice(Notice notice) {
        if (notice != null) {
            Integer integer = noticeMapper.publishNotice(notice);
            if (integer != null) {
                return ServletResponse.createBySuccessMessage("公告发布成功");
            }
        }

        return ServletResponse.createByErrorMessage("公告发布失败");
    }

    /*
    查询公告
     */
    public ServletResponse<PageInfo> select_notice(int pageNum, int pageSize) {
        //分页开始
        PageHelper.startPage(pageNum, pageSize);

        List<Notice> notices = noticeMapper.selectAll();
        if (!CollectionUtils.isEmpty(notices)) {
            //创建分页

            PageInfo pageInfo = new PageInfo(notices);

            return ServletResponse.createBySuccess(pageInfo);
        }
        return ServletResponse.createByErrorMessage("查询失败");
    }

    /*
    删除公告
     */
    public ServletResponse deleteNotice(Integer noticeId) {
        if (noticeId != null) {
            Integer integer = noticeMapper.delte_notice(noticeId);
            if (integer != null) {
                return ServletResponse.createBySuccessMessage("删除成功");
            }
        }
        return ServletResponse.createByErrorMessage("删除失败");
    }


}
