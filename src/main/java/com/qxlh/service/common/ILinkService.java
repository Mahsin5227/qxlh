package com.qxlh.service.common;

import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.common.Link;

public interface ILinkService{

    ResponseModel save(Link link);

    ResponseModel listByPage(Page page);

    ResponseModel allList();

    ResponseModel recommentList();

    ResponseModel update(Link link);

    ResponseModel delete(Integer id);

    Link findById(Integer id);

    ResponseModel enable(Integer id);
}
