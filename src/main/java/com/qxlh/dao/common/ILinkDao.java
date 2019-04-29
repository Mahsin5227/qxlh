package com.qxlh.dao.common;

import com.qxlh.core.Page;
import com.qxlh.model.common.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ILinkDao extends IBaseDao<Link>{

    /**
     * 分页查询
     * @param page
     * @return
     */
    List<Link> listByPage(@Param("page") Page page);

    List<Link> recommentList();

    int enable(@Param("id") Integer id);
}