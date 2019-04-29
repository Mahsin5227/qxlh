package com.qxlh.service.News.impl;

import com.qxlh.core.utils.HtmlUtil;
import com.qxlh.core.utils.StringUtils;
import com.qxlh.dao.News.IArchiveDao;
import com.qxlh.model.News.Archive;
import com.qxlh.model.user.User;
import com.qxlh.service.News.IArchiveService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ArchiveServiceImpl implements IArchiveService {
    @Resource
    private IArchiveDao archiveDao;
    @Override
    public Archive findByArchiveId(int id) {
        return archiveDao.findByArchiveId(id);
    }

    @Override
    public boolean save(User user, Archive archive) {
        archive.setUser(user);
        archive.setUserId(user.getId());
        if (archive.getViewCount() == null) {
            archive.setViewCount(0);
        }
        if (archive.getViewRank() == null) {
            archive.setViewRank(0);
        }
        if (StringUtils.isEmpty(archive.getDescription())) {

            String contentStr = HtmlUtil.delHTMLTag(archive.getContent());
            if (contentStr.length() > 200) {
                archive.setDescription(contentStr.substring(0, 200));
            } else {
                archive.setDescription(contentStr);
            }
        }
        if (StringUtils.isEmpty(archive.getThumbnail())) {
            Document doc = Jsoup.parseBodyFragment(archive.getContent());
            Elements elements = doc.select("img[src]");
            if (elements.size() > 0) {
                String imgsrc = elements.get(0).attr("src");
                archive.setThumbnail(imgsrc);
            }
        }
        return archiveDao.save(archive)==1;
    }

    @Override
    public boolean update(User user, Archive archive) {
        Archive findArchive = this.findByArchiveId(archive.getArchiveId());
        if (findArchive == null) {
            return false;
        }
        findArchive.setTitle(archive.getTitle());
        findArchive.setThumbnail(archive.getThumbnail());
        findArchive.setContent(archive.getContent());
        findArchive.setDescription(archive.getDescription());
        findArchive.setKeywords(archive.getKeywords());
        //普通会员
        if (user.getIs_admin() == 0) {
            if (user.getId().intValue() != findArchive.getUserId().intValue()) {
                return false;
            }
        } else {
            //管理员
            findArchive.setSource(archive.getSource());
            findArchive.setViewCount(archive.getViewCount());
            findArchive.setWriter(archive.getWriter());
            findArchive.setViewRank(archive.getViewRank());
        }
        if (findArchive.getViewCount() == null) {
            findArchive.setViewCount(0);
        }
        if (findArchive.getViewRank() == null) {
            findArchive.setViewRank(0);
        }
        if (StringUtils.isEmpty(findArchive.getDescription())) {
            String contentStr = HtmlUtil.delHTMLTag(findArchive.getContent());
            if (contentStr.length() > 200) {
                findArchive.setDescription(contentStr.substring(0, 200));
            } else {
                findArchive.setDescription(contentStr);
            }
        }
        if (StringUtils.isEmpty(findArchive.getThumbnail())) {
            Document doc = Jsoup.parseBodyFragment(findArchive.getContent());
            Elements elements = doc.select("img[src]");
            if (elements.size() > 0) {
                String imgsrc = elements.get(0).attr("src");
                findArchive.setThumbnail(imgsrc);
            }
        }
        return archiveDao.update(findArchive) == 1;
    }

    @Override
    public boolean delete(int id) {
        return archiveDao.delete(id)==1;
    }

    @Override
    public void updateViewCount(int id) {
        archiveDao.updateViewCount(id);
    }
}
