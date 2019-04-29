package com.qxlh.service.user.impl;

import com.qxlh.dao.user.IValidateCodeDao;
import com.qxlh.model.user.ValidateCode;
import com.qxlh.service.user.IValidateCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("validateCodeService")
public class ValidateCodeServiceImpl implements IValidateCodeService {
    @Resource
    private IValidateCodeDao validateCodeDao;

    @Override
    public boolean save(ValidateCode validateCode) {
        return validateCodeDao.save(validateCode) == 1;
    }

    @Override
    public ValidateCode valid(String email, String code, int type) {
        return validateCodeDao.valid(email,code,type);
    }

    @Override
    public boolean used(Integer id) {
        return validateCodeDao.used(id) == 1;
    }
}