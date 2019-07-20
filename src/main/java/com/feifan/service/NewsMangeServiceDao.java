package com.feifan.service;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;
import com.github.pagehelper.PageHelper;

;import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 新闻管理业务层接口
 * @author LL
 */

public interface NewsMangeServiceDao {

    /*  得到所有的新闻 */
     ServletResponse all(int pageNum) throws Exception;


    /*  得到所有的待审核新闻 */
    ServletResponse auditAll(int pageNum) throws Exception;

    /*  审核 */
    ServletResponse isSucc(int newsId, int sduts) throws Exception;

    /*  删除新闻 */
    ServletResponse del(int newsId) throws Exception;
}
