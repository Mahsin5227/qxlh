package com.qxlh.service.core.impl;

import com.qxlh.core.ResponseModel;
import com.qxlh.dao.core.IUniversityDao;
import com.qxlh.model.core.University;
import com.qxlh.service.core.IUniversityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UniversityServiceImpl implements IUniversityService {
    @Resource
    IUniversityDao universityDao;

    @Override
    public int save(University entity) {
        return universityDao.save(entity);
    }

    @Override
    public int update(University entity) {
        return universityDao.update(entity);
    }

    @Override
    public University findById(int id) {
        return null;
    }



    @Override
    public ResponseModel allList() {
        List<University> list = universityDao.allList();
        ResponseModel model = new ResponseModel(0);

        model.setData(list);
        return model;
    }
}
