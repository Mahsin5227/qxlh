package com.qxlh.service.News.impl;


import com.qxlh.core.ResponseModel;
import com.qxlh.dao.News.INewsCateDao;
import com.qxlh.dao.News.INewsDao;
import com.qxlh.model.News.NewsCate;
import com.qxlh.service.News.INewsCateService;
import com.qxlh.service.News.INewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("NewsCateService")
public class NewsCateSeriviceImpl implements INewsCateService {
    @Resource
    INewsDao newsDao;
    @Resource
    INewsCateDao newsCateDao;

    @Override
    public NewsCate findById(int id) {
        return newsCateDao.findById(id);
    }

    @Override
    public int save(NewsCate newsCate) {

        return newsCateDao.save(newsCate);
    }

    @Override
    public int update(NewsCate newsCate) {
        return newsCateDao.update(newsCate);
    }

    @Override
    public ResponseModel delete(int id) {
        List sonList = this.findListByFid(id);
        if(sonList.size() > 0){
            return new ResponseModel(-1,"请先删除子栏目");
        }
//        articleDao.setArticleAsNoneCate(id);
        int result = newsCateDao.delete(id);

        if(result == 1){
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

    @Override
    public List<NewsCate> list() {
        return newsCateDao.list();
    }

    @Override
    public List<NewsCate> findListByFid(int fid) {
        return newsCateDao.findListByFid(fid);
    }
}
