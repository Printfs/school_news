package com.feifan.service.impl;

import com.feifan.common.ServletResponse;
import com.feifan.dao.NewsMangeMapper;
import com.feifan.pojo.News;
import com.feifan.service.NewsMangeServiceDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * 新闻管理业务实现类
 * @author LL
 */
@Service
public class NewsMangeServiceImp implements NewsMangeServiceDao {

    @Resource
    NewsMangeMapper newsMangeMapper;



    /*  得到所有的新闻 */
    @Override
    public ServletResponse all( int pageNum) throws Exception {
        List<News> all = newsMangeMapper.getAll(pageNum);
//        System.out.println(pageNum+"  "+all);
//        //开始分页
//        PageHelper.startPage(pageNum,1);
//        System.out.println(pageNum);
//        //组装分页
//        PageInfo pageInfo=new PageInfo(all);
        return ServletResponse.createBySuccess(all);
    }



    /*  得到所有待审核的新闻 */
    @Override
    public ServletResponse auditAll( int pageNum) throws Exception {
        List<News> all = newsMangeMapper.getAuditAll(pageNum);
//        //开始分页
//        PageHelper.startPage(pageNum,5);
//        //组装分页
//        PageInfo pageInfo=new PageInfo(all);
        return ServletResponse.createBySuccess(all);
    }

    /*  审核 */
    @Override
    public ServletResponse isSucc(int newsId,int sduts) throws Exception {
        try {
            newsMangeMapper.updateSduts(newsId,sduts);
        }catch (Exception e){
            return ServletResponse.createByErrorMessage("审核发生错误");
        }
        return ServletResponse.createBySuccess();
    }


    /*  删除 */
    @Override
    public ServletResponse del(int newsId) throws Exception {
        try {
            newsMangeMapper.delNews(newsId);
        }catch (Exception e){
            return ServletResponse.createByErrorMessage("删除新闻时发生错误");
        }
        return ServletResponse.createBySuccess();
    }


    /*  判断当前是不是管理员 */
    public static boolean isAdmin(HttpSession session) throws Exception {
        return session.getAttribute("name")!=null;
    }




}