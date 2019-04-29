package com.qxlh.dao.News;

import com.qxlh.core.Page;
import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.News.News;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INewsDao extends IBaseDao<News> {
    int save(News news);

    List<News> listByPage(@Param("page") Page page,@Param("groupId") int groupId, @Param("key") String key, @Param("cateid") Integer cateid, @Param("status") Integer status, @Param("userId") Integer userId);

    /**
     * 设置某个栏目的所有文章为未分类文章，一般在删除某个栏目的时候调用
     * @param cateid
     * @return
     */
    int setNewsAsNoneCate(@Param("cateid") int cateid);

    /**
     * 更新阅读数
     * @param newsId
     * @return
     */
    int updateViewCount(@Param("newsId") int newsId);

    /**
     * 审核文章
     * @param id
     * @return
     */
    int audit(@Param("id") int id);

    News findById(@Param("id") Integer id, @Param("loginUserId") Integer loginUserId);

    /**
     * 自定义条件查询
     * @param cid 栏目ID，0不限制
     * @param sort 排序字段
     * @param num 获取数量
     * @param day 天，获取多少天之内的数据，0不限制
     * @param thumbnail 缩略图 0不限制，1必须有缩略图
     * @return
     */
    List<News> listByCustom(@Param("cid") int cid,@Param("sort") String sort,@Param("num") int num,@Param("day") int day,@Param("thumbnail") int thumbnail);
}

