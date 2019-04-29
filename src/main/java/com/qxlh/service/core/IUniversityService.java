package com.qxlh.service.core;

import com.qxlh.core.ResponseModel;
import com.qxlh.model.core.University;

import java.util.List;

public interface IUniversityService {
    int save(University university);
    int update(University university);
    University findById(int id);
    ResponseModel allList();

}
