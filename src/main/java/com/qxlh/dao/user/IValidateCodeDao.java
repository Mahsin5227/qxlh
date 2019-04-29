package com.qxlh.dao.user;

import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.user.ValidateCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IValidateCodeDao extends IBaseDao<ValidateCode> {

    /**
     * 验证，30分钟以内有效
     * @param email
     * @param code
     * @param type
     * @return
     */
    ValidateCode valid(@Param("email") String email, @Param("code") String code, @Param("type") int type);

    int used(@Param("id") Integer id);
}