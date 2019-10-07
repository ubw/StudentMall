<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="Stylesheet"/>
    <link href="../css/header.css" rel="Stylesheet"/>
    <link href="../css/footer.css" rel="Stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <link href="../css/password.css" rel="Stylesheet"/>
</head>
<body>
<!-- 页面顶部-->
<c:import url="header.jsp"></c:import>
<!-- nav主导航-->
<nav id="nav">
    <ul>
        <li><a href="index.jsp" class="acti">首页</a></li>
        <li><a href="index.jsp#computer" >电脑办公</a></li>
        <li><a href="index.jsp#stationery" >办公文具</a></li>
    </ul>
</nav>
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <c:import url="left_side_bar.jsp"></c:import>
    <!-- 右边栏-->
    <!--个人信息头部-->
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="personalinfo.do">我的信息</a></span>
            <span class="rs_header_active"><a href="password.do">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <div class="rs_content">
            <p class="change_password_title">更改密码</p>
            <div class="new_password">
                <span class="word">输入旧密码：</span><input id="old_password" type="password"/><span id="old_password_hint" class="change_hint"></span>
            </div>
            <div class="new_password">
                <span class="word">输入新密码：</span><input id="new_password" type="password"/><span id="new_password_hint" class="change_hint"></span>
            </div>
            <div class="confirm_password">
                <span class="word">确认新密码：</span><input id="confirm_password" type="password"/><span id="confirm_password_hint" class="confirm_hint"></span>
            </div>
            <div class="save_password">
                <buttor id="saveButton" onclick="changePassword()">保存更改</buttor>
            </div>
        </div>


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script>
    function checkPasswordLength(pwd){
        return pwd.length >=6;
    }

    function checkPasswordEquals(pwd1, pwd2){
        return pwd1 == pwd2;
    }

    function changePassword(){
        //获取3个密码
        var oldPwd =  $("#old_password").val();
        var newPwd =  $("#new_password").val();
        var confirmPwd =  $("#confirm_password").val();

        if (checkPasswordLength(oldPwd)  && checkPasswordLength(newPwd) &&  checkPasswordLength(confirmPwd) && checkPasswordEquals(newPwd, confirmPwd)) {
            //异步提交请求修改密码
            $.ajax({
                "url":"handle_changepassword.do",
                "data":"old_password="+oldPwd+"&new_password="+newPwd,
                "type":"POST",
                "dataType":"json",
                "success":function (obj) {
                    alert(obj.msg);
                    $("#old_password").val("");
                    $("#new_password").val("");
                    $("#confirm_password").val("");
                },
                "error":function () {
                    alert("未登陆或异常错误发生");
                    location.href = "../main/index.do"
                }
            });

        } else {
            alert("输入的密码存在错误");
        }
    }

    $("#old_password").blur(function(){
        console.log("old password blur");
        //获取密码
        var pwd = $("#old_password").val();
        console.log("old password:"+pwd);
        console.log("old password check:"+checkPasswordLength(pwd));
        if (checkPasswordLength(pwd)){
            $("#old_password_hint").text("密码长度正确");
            $("#old_password_hint").attr("class", "msg-success");
        } else {
            $("#old_password_hint").text("密码长度要在6位以上");
            $("#old_password_hint").attr("class", "msg-error");
        }
    });

    $("#new_password").blur(function(){
        //获取密码
        var pwd = $("#new_password").val();
        if (checkPasswordLength(pwd)){
            $("#new_password_hint").html("密码长度正确");
            $("#new_password_hint").attr("class", "msg-success");
        } else {
            $("#new_password_hint").html("密码长度要在6位以上");
            $("#new_password_hint").attr("class", "msg-error");
            return;
        }

        var pwd1 = $("#new_password").val();
        var pwd2 = $("#confirm_password").val();
        console.log("newpassword confirm check:"+checkPasswordEquals(pwd1, pwd2));
        if (checkPasswordEquals(pwd1, pwd2)){
            $("#confirm_password_hint").html("密码一致");
            $("#confirm_password_hint").attr("class", "msg-success");
        } else {
            $("#confirm_password_hint").html("密码不一致");
            $("#confirm_password_hint").attr("class", "msg-error");
        }

    });

    $("#confirm_password").blur(function(){
        //获取密码
        var pwd = $("#confirm_password").val();
        if (checkPasswordLength(pwd)){
            $("#confirm_password_hint").html("密码长度正确");
            $("#confirm_password_hint").attr("class", "msg-success");
        } else {
            $("#confirm_password_hint").html("密码长度要在6位以上");
            $("#confirm_password_hint").attr("class", "msg-error");
            return;
        }

        var pwd1 = $("#new_password").val();
        var pwd2 = $("#confirm_password").val();
        console.log("newpassword confirm check:"+checkPasswordEquals(pwd1, pwd2));
        if (checkPasswordEquals(pwd1, pwd2)){
            $("#confirm_password_hint").html("密码一致");
            $("#confirm_password_hint").attr("class", "msg-success");
        } else {
            $("#confirm_password_hint").html("密码不一致");
            $("#confirm_password_hint").attr("class", "msg-error");
        }
    });

    //左侧栏显示账号管理
    $(function(){
        //影藏所有菜单项目
        $("#leftsidebar_box dd").hide();
        //显示账号管理所有菜单项
        $("#leftsidebar_box .count_managment dd").show();
        //所有标题右侧图片箭头为向下
        $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
        //账号管理为向右
        $("#leftsidebar_box .count_managment dt img").attr("src","../images/myOrder/myOrder1.png");
    });
</script>
</body>
</html>