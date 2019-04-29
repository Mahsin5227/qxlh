package com.qxlh.service.News;

import com.qxlh.core.Page;
import com.qxlh.core.ResponseModel;
import com.qxlh.model.News.News;
import com.qxlh.model.user.User;

import java.util.List;

public interface INewsService {
    News findById(int id);

    News findById(int id,User loginUser);

    ResponseModel save(User member,News news);

    ResponseModel update(User member,News news);

    ResponseModel delete(User member,int id);

    ResponseModel listByPage(Page page, int groupId,String key, int cateid, int status, int memberId);

    void updateViewCount(int id);

    ResponseModel audit(int id);

    List<News> listByCustom(int cid, String sort, int num, int day, int thumbnail);


}
