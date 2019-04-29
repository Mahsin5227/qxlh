package com.qxlh.service.system;

import com.qxlh.core.ResponseModel;
import com.qxlh.model.System.Action;

import java.util.List;

public interface IActionService {

    List<Action> list();

    Action findById(Integer id);

    ResponseModel update(Action action);

    ResponseModel isenable(Integer id);

    boolean canuse(Integer id);
}