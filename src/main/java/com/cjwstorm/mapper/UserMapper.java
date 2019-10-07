package com.cjwstorm.mapper;

import com.cjwstorm.bean.User;
import org.apache.ibatis.annotations.Param;

//只能取UserMapper 这个名字，取IUserMapper会报错，为啥？？
public interface UserMapper {
    void insertUser(User user);
    Integer updateAttribute(User user);
    //Param注解很重要，不然报错找不到参数？？
    User findUserByNameOrId(@Param("userName") String userName, @Param("id") Integer id);
    //传多个参数要加Param注解
    User findUserByNameAndPwd(@Param("userName") String userName1, @Param("password") String password);
    User findUserByPhone(String phone);
    User findUserByEmail(String email);
}
