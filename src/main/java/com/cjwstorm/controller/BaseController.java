package com.cjwstorm.controller;

import javax.servlet.http.HttpSession;

public abstract class BaseController {

    //uid比较常用，从子类中抽出来
    protected Integer getUidFromSession(HttpSession session){
        Object uidObj = session.getAttribute("uid");
        if (uidObj == null){
            return null;
        }
        return Integer.valueOf(uidObj.toString());
    }

}
