package com.qxlh.dao.core;

import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.core.University;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUniversityDao extends IBaseDao<University> {
    University findById(@Param("id") Integer id);
}
