package com.feifan.service;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.Notice;
import com.github.pagehelper.PageInfo;

public interface NoticeService {

    public ServletResponse publish_notice(Notice notice);


    public ServletResponse<PageInfo> select_notice(int pageNum, int pageSize);

    public ServletResponse deleteNotice(Integer noticeId);
}
