package com.qxlh.service.News.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qxlh.core.Const;
import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.core.utils.ConfigUtil;
import com.qxlh.core.utils.StringUtils;
import com.qxlh.dao.News.INewsDao;
import com.qxlh.dao.system.IActionDao;
import com.qxlh.model.News.Archive;
import com.qxlh.model.News.News;
import com.qxlh.model.user.User;
import com.qxlh.service.News.IArchiveService;
import com.qxlh.service.News.INewsService;
import com.qxlh.service.system.IActionService;
import com.qxlh.service.system.IConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements INewsService {

    @Resource
    private INewsDao newsDao;
    @Resource
    private IConfigService configService;
    @Resource
    private IArchiveService archiveService;



    @Override
    public News findById(int id) {
        return newsDao.findById(id);
    }

    @Override
    public News findById(int id, User loginUser) {
        if(loginUser.getId()!=null){
            return  newsDao.findById(id,loginUser.getId());
        }
        return null;
    }

    @Override
    public ResponseModel save(User user, News news) {
        Map<String,String> config = configService.getConfigToMap();
        if(user.getIs_admin() == 0 && "0".equals(config.get(ConfigUtil.CMS_POST))){
            return new ResponseModel(-1,"新闻发布功能已关闭");
        }
        if(news.getCateId() == null || news.getCateId() == 0){
            return new ResponseModel(-1,"栏目不能为空");
        }
        news.setUserId(user.getId());
       // news.setGroupId(user.getGroupId);
        news.setGroupId(0);
        Archive archive = new Archive();
        try {
            //复制属性值
            archive = archive.copy(news);
        } catch (Exception e) {
            e.printStackTrace();
        }
        archive.setPostType(1);
        if(user.getIs_admin() == 0 && "0".equals(config.get(ConfigUtil.CMS_POST_REVIEW))){
            news.setStatus(0);
        }else {
            news.setStatus(1);
        }
        //保存文档
        if(archiveService.save(user,archive)){
            //保存文章
            news.setArchiveId(archive.getArchiveId());
            int result = newsDao.save(news);
            if(result == 1){

              //  actionLogService.save(user.getCurrLoginIp(),user.getId(), ActionUtil.POST_ARTICLE,"", ActionLogType.ARTICLE.getValue(),news.getId());
                if (news.getStatus() == 0){
                    return new ResponseModel(0,"文章发布成功，请等待审核");
                }
                return new ResponseModel(0,"文章发布成功","/news/detail/"+news.getId());
            }
        }
        return new ResponseModel(-1,"文章发布失败");

    }

    @Override
    public ResponseModel update(User user, News news) {
        News findNews = this.findById(news.getId(),user);
        if(findNews == null){
            return new ResponseModel(-2);
        }
        news.setArchiveId(findNews.getArchiveId());
        Archive archive = new Archive();
        try {
            //复制属性值
            archive = archive.copy(news);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(archiveService.update(user,archive)){
            Map<String,String> config = configService.getConfigToMap();
            if(user.getIs_admin() == 0 && "0".equals(config.get(ConfigUtil.CMS_POST_REVIEW))){
                findNews.setStatus(0);
            }else {
                findNews.setStatus(1);
            }
            //更新栏目
            findNews.setCateId(news.getCateId());
            newsDao.update(findNews);
            return new ResponseModel(0,"更新成功");
        }
        return new ResponseModel(-1,"更新失败");
    }

    @Override
    public ResponseModel delete(User user, int id) {
        News news = this.findById(id);
        if (news == null){
            return new ResponseModel(-1,"文章不存在");
        }

        int result = newsDao.delete(id);
        if(result == 1){


            archiveService.delete(news.getArchiveId());

           // actionLogService.save(user.getCurrLoginIp(),user.getId(), ActionUtil.DELETE_ARTICLE,"ID："+news.getId()+"，标题："+news.getTitle());
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

    @Override
    public ResponseModel listByPage(Page page, int groupId,String key, int cateid, int status, int userId) {
        if (StringUtils.isNotBlank(key)){
            key = "%"+key+"%";
        }
        PageHelper.startPage(page.getPageNo(), page.getPageSize());
        List<News> list = newsDao.listByPage(page,groupId, key,cateid,status,userId);
        PageInfo<News> pageInfo = new PageInfo<>(list);
        ResponseModel model = new ResponseModel(0);
        model.setPageInfo(pageInfo);
        model.setData(list);

//
//        List<News> list = newsDao.listByPage(page, key,cateid,status,userId);
//        page.setTotalCount(list.size());
//        ResponseModel model = new ResponseModel(0,page);
//        model.setData(list);
        return model;
    }


    @Override
    public void updateViewCount(int id) {
        newsDao.updateViewCount(id);
    }

    @Override
    public ResponseModel audit(int id) {
        if(newsDao.audit(id) == 1){
            return new ResponseModel(1,"操作成功");
        }else {
            return new ResponseModel(-1,"操作时候");
        }
    }



    @Override
    public List<News> listByCustom(int cid, String sort, int num, int day, int thumbnail) {
        return null;
    }
}
