package com.qxlh.dao.system;

import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.System.Config;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IConfigDao extends IBaseDao<Config> {

    boolean update(@Param("key") String Skey, @Param("value") String Svalue);

    String getValue(@Param("key") String key);
}
