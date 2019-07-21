package com.feifan.controller;

import com.feifan.common.ServletResponse;
import com.feifan.pojo.News;
import com.feifan.security.JwtUtil;
import com.feifan.service.NewsMangeServiceDao;
import com.feifan.service.impl.NewsMangeServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.feifan.service.impl.NewsMangeServiceImp.isAdmin;

/**
 * 新闻管理控制器
 *
 * @author LL
 */

@CrossOrigin    //跨域
@Controller
@RequestMapping("/NewsMange/")
public class NewsManageController {

    /* 注入新闻管理service层  调用其逻辑方法 */
    @Resource
    NewsMangeServiceImp newsMangeServiceImp;

    /*  得到所有新闻 */
    @RequestMapping("all.do")
    @ResponseBody
    public ServletResponse<List<News>> getAll(@RequestParam(value = "pageNum") int pageNum, String key) throws Exception {
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null) {
            return newsMangeServiceImp.all(pageNum);
        }
        return ServletResponse.createByErrorMessage("没有权限");
    }


    /*  得到所有待审核新闻 */
    @RequestMapping("Audit.do")
    @ResponseBody
    public ServletResponse<List<News>> getAuditAll(@RequestParam(value = "pageNum") int pageNum, String key) throws Exception {
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null) {
            return newsMangeServiceImp.auditAll(pageNum);
        }
        return ServletResponse.createByErrorMessage("没有权限");
    }


    /*  审核成功 */
    @RequestMapping("isSuccess.do")
    @ResponseBody
    public ServletResponse isSuccess(@RequestParam(value = "newsId", defaultValue = "0") int newsId,
                                     @RequestParam(value = "sduts", defaultValue = "0") int sduts, String key) throws Exception {
        String useremail = JwtUtil.getUsername(key);


        if (useremail != null) {
            return newsMangeServiceImp.isSucc(newsId, sduts);
        }
        return ServletResponse.createByError();
    }


    /*   删除新闻 */
    @RequestMapping("Delete.do")
    @ResponseBody
    public ServletResponse delete(@RequestParam(value = "newsId", defaultValue = "0") int newsId, String key) throws Exception {
       String useremail = JwtUtil.getUsername(key);


        if (useremail != null){
           return newsMangeServiceImp.del(newsId);
        }
        return ServletResponse.createByError();
    }


}
