package com.qxlh.service.News;

import com.qxlh.core.ResponseModel;
import com.qxlh.model.News.NewsCate;

import java.util.List;

public interface INewsCateService {


    NewsCate findById(int id);

    int save(NewsCate articleCate);

    int update(NewsCate articleCate);

    ResponseModel delete(int id);

    /**
     * 获取栏目
     * @return
     */
    List<NewsCate> list();

    /**
     * 通过父类ID获取子类列表
     * @param fid
     * @return
     */
    List<NewsCate> findListByFid(int fid);
}
