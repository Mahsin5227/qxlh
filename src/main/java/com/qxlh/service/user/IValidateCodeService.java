package com.qxlh.service.user;

import com.qxlh.model.user.ValidateCode;

public interface IValidateCodeService {

    boolean save(ValidateCode validateCode);

    /**
     * 验证，30分钟以内有效
     * @param email
     * @param code
     * @param type
     * @return
     */
    ValidateCode valid(String email, String code, int type);

    boolean used(Integer id);
}