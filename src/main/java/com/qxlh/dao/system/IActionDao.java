package com.qxlh.dao.system;

import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.System.Action;
import org.apache.ibatis.annotations.Param;


public interface IActionDao extends IBaseDao<Action> {
    int isenable(@Param("id") Integer id);
}
