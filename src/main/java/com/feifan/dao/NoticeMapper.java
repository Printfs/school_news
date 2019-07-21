package com.feifan.dao;

import com.feifan.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface NoticeMapper {

    //发布
    public Integer publishNotice(Notice notice);
    //查询
    public List<Notice> selectAll();
    //删除
    public Integer delte_notice(Integer noticeId);

    //模糊查询
    public List<Notice> likeNotice(@RequestParam(value = "text") String text);

}
