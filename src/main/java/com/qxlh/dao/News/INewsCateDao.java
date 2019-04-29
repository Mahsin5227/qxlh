package com.qxlh.dao.News;

import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.News.NewsCate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INewsCateDao extends IBaseDao<NewsCate> {
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
    List<NewsCate> findListByFid(@Param("fid") int fid);
    List<NewsCate> findListByGroupId(@Param("gid") int gid);
}
