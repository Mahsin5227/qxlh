package com.qxlh.dao.system;


import com.qxlh.core.Page;
import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.System.ActionLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface IActionLogDao extends IBaseDao<ActionLog> {

    List<ActionLog> listByPage(@Param("page") Page page, @Param("memberId") Integer memberId);

    List<ActionLog> memberActionLog(@Param("page") Page page, @Param("memberId") Integer memberId);
    List<ActionLog> memberActionLogFocus(@Param("page") Page page, @Param("memberIds") Integer[] memberIds);
}
