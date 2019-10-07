package com.cjwstorm.controller;

import com.cjwstorm.bean.ResponseResult;
import com.cjwstorm.bean.User;
import com.cjwstorm.service.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

@Controller
public class UserController extends BaseController{
    @Resource(name="userService")
    private IUserService userService;

    @Value("#{dbProperties.salt}")
    private  String SALT;

    //取名/usr/register.do方便前端html页面查上一级的css,pictuer等页面..
    @RequestMapping("/usr/register.do")
    public String register(){
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value="/usr/handle_register.do")
    @ResponseBody
    public ResponseResult<Void> handleRegister(@RequestParam("userName") String userName, String password,  String phone, String email){
        System.out.println("reg in");
        ResponseResult<Void> ret = new ResponseResult<>();
        try {
            System.out.println("测试salt:"+SALT);
            User user = new User(userName, DigestUtils.md5Hex(password+SALT), phone, email, 2);
            System.out.println("用户加密后的密码是："+user.getPassword());
            userService.register(user);
            ret.setState(user.getId());
            System.out.println("可以注册");
            ret.setMsg("可以注册");
        } catch (Exception e){
            e.printStackTrace();
            ret.setState(-1);
            ret.setMsg(e.getMessage());
            System.out.println(e.getMessage());
        }

        return ret;
    }

    @RequestMapping("/usr/login.do")
    public String login(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value="/usr/handle_login.do")
    @ResponseBody
    public ResponseResult<Void> handleLogin(@RequestParam("lname") String name,@RequestParam("lwd") String password, HttpSession session){
        System.out.println("login 输入的用户名："+name);
        System.out.println("login 输入的密码："+password);
        User user = userService.login(name, DigestUtils.md5Hex(password+SALT));
        System.out.println("login 输入的密码转换成密文："+DigestUtils.md5Hex(password+SALT));
        ResponseResult<Void> ret = new ResponseResult<>();
        try {
            ret.setState(user.getId());
            ret.setMsg("登陆成功");

            //登陆成功，写入session用户相关数据，返回session
            session.setAttribute("uid", user.getId());
            session.setAttribute("username", user.getUserName());
            System.out.println("setssion 写入 uid"+user.getId());
        } catch (Exception e){
            ret.setState(-1);
            ret.setMsg(e.getMessage());
        }

        return ret;
    }


    @RequestMapping(method = RequestMethod.POST, value="/usr/handle_changepassword.do")
    @ResponseBody
    public ResponseResult<Void> handleChangePassword(@RequestParam("old_password") String oldPassword,@RequestParam("new_password") String newPassword, HttpSession session){
        Integer iRet = 0;
        ResponseResult<Void> ret = null;

        System.out.println("改密码 输入旧密码："+oldPassword);
        System.out.println("输入的新密码："+newPassword);

        //从session中获取uid,不用强转，用Integer的方法
        //Controller中uid都是常用的部分，提取一个父类出来，放到父类的方法。
        Integer id = getUidFromSession(session);
        if (id == null){
            ret = new ResponseResult<>(0, "uid获取失败");
            return ret;
        }
        System.out.println("session中获取到的Id为"+id);

        try {
            iRet = userService.changePassword(id, DigestUtils.md5Hex(oldPassword+ SALT),
                                        DigestUtils.md5Hex(newPassword+ SALT));
            ret = new ResponseResult<>(1, "修改密码成功");
        } catch (Exception e) {
            e.printStackTrace();
            ret = new ResponseResult<>(0, e);
        }

        return  ret;
    }


    @RequestMapping(method = RequestMethod.POST, value="/usr/handle_edit_userinfo.do")
    @ResponseBody
    public ResponseResult<Void> handleEditUserInfo(String username, String phone, String email, Integer gender, HttpSession session){
        System.out.println("处理修改个人信息");

        Integer uid = getUidFromSession(session);
        if (uid == null){
            return new ResponseResult<>(-1, "未登陆");
        }

        try {
            Integer ret = userService.editPersonalInfo(uid, username, phone, email, gender);
            if(ret != 0){
                return new ResponseResult<>(-1, "没有更新成功");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseResult<>(-1, e);
        }

        //更新session中的姓名
        session.setAttribute("username", username);
        return new ResponseResult<>(0,"已更新");
    }

    @RequestMapping("/usr/logout.do")
    public String handleLogOut(HttpSession session){
        System.out.println("登出");
        //session失效
        session.invalidate();
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value="/usr/checkUserName.do")
    @ResponseBody
    public ResponseResult<?> checkUserName(String userName){
        System.out.println("1111");
        ResponseResult<User> ret = new ResponseResult<>();
        try {
            userService.checkUserNameUseable(userName);
            ret.setState(0);
            ret.setMsg("用户名可用");
        } catch (Exception e){
            e.printStackTrace();
            ret.setState(-1);
            ret.setMsg(e.getMessage());
            System.out.println("用户名不可用");
        }

        return ret;
    }

    @RequestMapping(method = RequestMethod.GET, value="/usr/checkPhone.do")
    @ResponseBody
    public ResponseResult<?> checkPhone(String phone){

        ResponseResult<User> ret = new ResponseResult<>();
        try {
            userService.checkPhoneUseable(phone);
            ret.setState(0);
            ret.setMsg("手机号码可用");
        } catch (Exception e){
            e.printStackTrace();
            ret.setState(-1);
            ret.setMsg(e.getMessage());
        }

        return ret;
    }


    @RequestMapping(method = RequestMethod.GET, value="/usr/checkEmail.do")
    @ResponseBody
    public ResponseResult<?> checkEmail(String email){

        System.out.println("111");
        ResponseResult<User> ret = new ResponseResult<>();
        try {
            userService.checkEmailUseable(email);
            ret.setState(0);
            ret.setMsg("邮箱可用");
        } catch (Exception e){
            e.printStackTrace();
            ret.setState(-1);
            ret.setMsg(e.getMessage());
        }

        return ret;
    }

    @RequestMapping("/usr/password.do")
    public String handlePassword(){
        System.out.println("修改密码");
        return "personal_password";
    }

    //和其他的有所不同，因为要显示一些数据。
    @RequestMapping("/usr/personalinfo.do")
    public String handlePersonalInfo(ModelMap modelMap, HttpSession session){
        System.out.println("返回修改个人信息");
        Integer id = getUidFromSession(session);

        User user = userService.findUserByNameOrId(null, id);
        System.out.println("检查有没有取出phone"+user.getPhone());
        modelMap.addAttribute("user", user);
        return "personalinfo";
    }

    @RequestMapping(value = "/usr/identifyCode.do", produces = "image/png")
    @ResponseBody
    public byte[] showIdentifyCode(HttpSession session) throws IOException {
        //设置画对象
        BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_3BYTE_BGR);

        //生成4位随机数
        String randomNumber = createRandomNumber(4);
        System.out.println("4位随机数字是:"+randomNumber);

        //画干扰点
        Random r = new Random();
        for (int i = 0; i<500; i++){
            image.setRGB(r.nextInt(image.getWidth()), r.nextInt(image.getHeight()), r.nextInt(0xffffff));
        }
        //画随机数
        Graphics2D g = image.createGraphics();
        //设置颜色
        g.setColor(new Color(r.nextInt(0xffffff)));
        //设置大小
        g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 25));

        //画干扰线
        for (int i = 0; i<5; i++){
            g.drawLine(r.nextInt(image.getWidth()), r.nextInt(image.getHeight()),
                    r.nextInt(image.getWidth()),  r.nextInt(image.getHeight()));
        }
        g.drawString(randomNumber, 10, 25);


        //图片输出
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "png", out);
        byte[] retByte = out.toByteArray();
        out.close();

        //将随机数写入session
        session.setAttribute("identifyCode", randomNumber);

        return retByte;
    }

    private String createRandomNumber(int num){
        String stringPool = "abcdefghijkmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        Random r = new Random();
        char[] ret = new char[num];
        for (int i = 0; i < num; i++){
            ret[i] = stringPool.charAt(r.nextInt(stringPool.length()));
            System.out.println(ret[i]);
        }

        //不能用toStrng()方法
        return String.valueOf(ret);
    }


    @RequestMapping(method = RequestMethod.GET, value="/usr/checkIdentifyCode.do")
    @ResponseBody
    public ResponseResult<Void> checkIdentifyCode(String identifyCode, HttpSession session){

        System.out.println("checkIdentifyCode in");
        ResponseResult<Void> ret = null;

        //从session拿出验证码
        String sessionIdentifyCode = (String)session.getAttribute("identifyCode");
        if(identifyCode == null || sessionIdentifyCode == null){
            System.out.println("验证码是空");
            ret = new ResponseResult<>(-1, "验证码为null");
        }

        if(identifyCode.equals(sessionIdentifyCode)){
            ret = new ResponseResult<>(0, "验证成功");
        } else {
            ret = new ResponseResult<>(-1, "验证失败");
        }

        return ret;
    }
}
