package com.qxlh.service.system.impl;

import com.qxlh.core.ResponseModel;
import com.qxlh.dao.system.IActionDao;
import com.qxlh.model.System.Action;
import com.qxlh.service.system.IActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActionServiceImpl implements IActionService {
    @Resource
    private IActionDao actionDao;

    @Override
    public List<Action> list() {
        return actionDao.allList();
    }

    @Override
    public Action findById(Integer id) {
        return actionDao.findById(id);
    }

    @Override
    public ResponseModel update(Action action) {
        if(actionDao.update(action) == 1){
            return new ResponseModel(3,"操作成功");
        }
        return new ResponseModel(-1,"操作失败");
    }

    @Override
    public ResponseModel isenable(Integer id) {
        if(actionDao.isenable(id) == 1){
            return new ResponseModel(1,"操作成功");
        }
        return new ResponseModel(-1,"操作失败");
    }

    /**
     * 状态是否能使用
     * @param id
     * @return true可以使用，false不能使用
     */
    @Override
    public boolean canuse(Integer id) {
        Action action = this.findById(id);
        if(action == null){
            return false;
        }
        if(action.getStatus() == 1){
            return false;
        }
        return true;
    }
}
