package com.qxlh.service.News;

import com.qxlh.model.News.Archive;
import com.qxlh.model.user.User;

public interface IArchiveService {
    Archive findByArchiveId(int id);

    boolean save(User user, Archive archive);

    boolean update(User user, Archive archive);

    boolean delete(int id);

    void updateViewCount(int id);
}
