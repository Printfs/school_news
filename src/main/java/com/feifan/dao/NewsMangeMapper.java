package com.feifan.dao;

import com.feifan.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author LL
 */


@Mapper
public interface NewsMangeMapper {

    /*  得到所有新闻 */
    List<News> getAll(int start);

    /*  得到所有新闻排序 */
    List<News> getAuditAll(int start);

    /*  审核,修改状态码 */
    void updateSduts(int newsId, int statusId);

    /*  删除新闻 */
    void delNews(int newsId);

    void ins();

}
