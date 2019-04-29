package com.qxlh.dao.News;

import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.News.Archive;
import org.apache.ibatis.annotations.Param;

public interface IArchiveDao extends IBaseDao<Archive> {

    Archive findByArchiveId(@Param("archiveId") Integer archiveId);

    /**
     * 更新阅读数
     * @param archiveId
     * @return
     */
    int updateViewCount(@Param("archiveId") int archiveId);


}