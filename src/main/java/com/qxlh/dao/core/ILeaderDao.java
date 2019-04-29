package com.qxlh.dao.core;

import com.qxlh.dao.common.IBaseDao;
import com.qxlh.model.core.Leader;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ILeaderDao extends IBaseDao<Leader> {
    List<Leader> allList();
    List<Leader> findByUid(int uid);

}
