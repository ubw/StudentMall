package com.cjwstorm.service;

import com.cjwstorm.bean.User;


public interface IUserService {
    Integer register(User user);
    User login(String name, String password);
    Integer changePassword(Integer id, String oldPassword, String newPassWord);
    Integer editPersonalInfo(Integer uid, String name, String mobile, String mail, Integer gender);
    Integer checkUserNameUseable(String userName);
    Integer checkPhoneUseable(String phone);
    Integer checkEmailUseable(String email);
    User findUserByNameOrId(String name, Integer id);
}
