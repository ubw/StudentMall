package com.cjwstorm.service;

import com.cjwstorm.bean.User;
import com.cjwstorm.mapper.UserMapper;
import com.cjwstorm.service.ex.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource(name="userMapper")
    private UserMapper userMapper;

    //常用的业务放在前面注册，登陆
    @Override
    public Integer register(User user) {
        if (checkUserNameUseable(user.getUserName()) == 0) {
            userMapper.insertUser(user);
            return user.getId();
        }

        return -1;
    }

    @Override
    public User login(String usrName, String password) {
        System.out.println("login service ");
        User user = null;
        try {
            user = userMapper.findUserByNameAndPwd(usrName, password);
            if (user == null){
                throw new UserNotFoundByNameAndPwdException("用户名或密码错误");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }
    @Override
    public Integer changePassword(Integer id, String oldPassword, String newPassWord){
        Integer ret = 0;
        User user = findUserByNameOrId(null, id);
        if (user == null){
            throw new UsrIdNotFoundException("用户id没有找到");
        }

        if (!user.getPassword().equals(oldPassword)){
            throw new PassWordNotMatchException("用户旧密码输入不对");
        }

        User newUser = new User();
        newUser.setId(id);
        newUser.setPassword(newPassWord);
        try {
            ret = userMapper.updateAttribute(newUser);
        } catch (Exception e){
            e.printStackTrace();
        }

        return ret;
    }

    //编辑个人信息
    public Integer editPersonalInfo(Integer uid, String name, String mobile, String mail, Integer gender){
        System.out.println("editPersonalInfo in");
        User newUser = new User();

        //设置uid,服务层不处理session的，session由控制器层处理
        if (uid != null){
            newUser.setId(uid);
        }

        //设置手机
        if (mobile != null && !mobile.equals("")){
            newUser.setPhone(mobile);
        }

        //设置邮箱
        if (mail != null && !mail.equals("")){
            newUser.setEmail(mail);
        }

        //设置性别
        if (gender != null && (gender == 0 || gender == 1)){
            newUser.setGender(gender);
        }

        //设置姓名
        //如果自己抛出的异常，放在try...catch...中的try中，也能catch到
        if (name != null && !name.equals("")){
            User user = findUserByNameOrId(null, uid);
            if (user == null){
                throw new UsrIdNotFoundException("uid没有找到");
            }

            //要设置的名字和原名字不同
            if (!user.getUserName().equals(name)){
                //根据要设置的名字查数据库
                User userByName = findUserByNameOrId(name, null);
                if (userByName == null){
                    //要设置的名字没查到，没有被占用
                    newUser.setUserName(name);
                } else {
                    //要设置的名字查到了，被占用了
                    throw new UserNameDuplicatedException("用户名已经被占用");
                }
            }
        }

        try {
            Integer ret = userMapper.updateAttribute(newUser);
            System.out.println("受影响的行数:"+ret);
        } catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    @Override
    public Integer checkUserNameUseable(String userName) throws UserNameDuplicatedException{
        System.out.println(userName);
        User user = findUserByNameOrId(userName, null);

        if (user != null){
            System.out.println("用户名已被占用");
            throw new UserNameDuplicatedException("用户名已被占用");
        }
        System.out.println(user);
        return 0;
    }

    @Override
    public Integer checkPhoneUseable(String phone) throws PhoneDuplicatedException{
        User user = userMapper.findUserByPhone(phone);

        if (user != null){
            throw new PhoneDuplicatedException("手机号已注册");
        }

        return 0;
    }

    @Override
    public Integer checkEmailUseable(String email) throws EmailDuplicatedException{
        System.out.println("email:"+email);
        User user = userMapper.findUserByEmail(email);
        System.out.println("usr:"+user);
        if (user != null){
            throw new EmailDuplicatedException("邮箱已注册");
        }

        return 0;
    }

    //把调用mapper的方法抽出来作为service的一个方法
    public User findUserByNameOrId(String name, Integer id){
        User user = null;

        user = userMapper.findUserByNameOrId(name, id);

        return user;
    }
}
