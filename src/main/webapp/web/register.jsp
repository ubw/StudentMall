<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>学子商城注册页面</title>
  <link href="../css/header.css" rel="stylesheet"/>
  <link href="../css/footer.css" rel="stylesheet"/>
  <link href="../css/animate.css" rel="stylesheet"/>
  <link href="../css/login.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<header id="top">
  <div class="top">
    <img src="../images/header/logo.png" alt=""/>
    <span>欢迎注册</span>
  </div>
</header>
<div class="parent">
  <!--<video src="audio/snow.mp4" width="100%" autoplay loop muted></video>-->
  <div class="container">
    <div class="panel rt">
      <!--此处只能填相对路径handle_register.do-->
      <form id="form-register">
        <div class="txt">
          <p>新用户注册
            <span>
              <a href="login.do">直接登录</a>
            </span>
          </p>
        </div>
        <div class="form-group">
          <label for="userName">用户名：</label>
          <input autocomplete required minlength="6" maxlength="9" type="text" placeholder="请输入用户名" autofocus name="userName" id="userName"/>
          <span id="usrHint" class="msg-default">用户名长度在6到9位之间</span>
        </div>
        <div class="form-group">
          <label for="password">登录密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请输入密码" name="password" autofocus id="password"/>
          <span class="msg-default hidden">密码长度在6到12位之间</span>
        </div>
		 <div class="form-group">
          <label for="upwdconfirm">确认密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请确认密码" name="upwdconfirm" autofocus id="upwdconfirm"/>
          <span class="msg-default hidden">密码长度在6到12位之间</span>
        </div>
        <div class="form-group">
          <label for="email">邮箱：</label>
          <input autocomplete required type="email" placeholder="请输入邮箱地址" name="email" id="email"/>
          <span id="email_hint" class="msg-default hidden">请输入合法的邮箱地址</span>
        </div>
        <div class="form-group">
          <label for="phone">手机号：</label>
          <input id="phone" name="phone" placeholder="请输入您的手机号" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" required type="text" />
          <span id="phone_hint" class="msg-default hidden">请输入合法的手机号</span>
        </div>
        <div class="form-group">
          <label></label>
          <input type="button" value="提交注册信息" id="bt-register" onclick="register()"/>
        </div>
      </form>
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
    <div class="foot_left lf" >
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
      <p>商城客户端</p>
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
<!--弹出的小广告-->
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
    /*
  $('#bt-register').click(function(){
    var lengths=0;
    $('.form-group').each(function(){
      if($(this).find('span').hasClass('msg-success')){
        lengths++;
      }
      if(lengths==4){
        $('.modal').fadeIn();
        setTimeout(function(){
          window.location.href='login.jsp';
        },2000);
      }
    });
  })
  */

    /*1.对用户名进行验证*/
    $('#userName').blur(function() {
      //初始化，validationMessage属性，用于自定义提示
      this.setCustomValidity("");
      if (this.validity.valueMissing) {
        this.nextElementSibling.innerHTML = '用户名不能为空';
        this.nextElementSibling.className = 'msg-error';
        this.setCustomValidity('用户名不能为空');
        console.log("用户名不能为空")
        return;
      } else if (this.validity.tooShort) {
        this.nextElementSibling.innerHTML = '用户名不能少于6位';
        this.nextElementSibling.className = 'msg-error';
        this.setCustomValidity('用户名不能少于6位');
        console.log("用户名不能少于6位,"+this.val().length);
        return;
      } else {
          this.setCustomValidity("");
      }


      //url不用填全？？因为注册本身已经在usr目录下了
      $.ajax({
        url: "checkUserName.do",
        data: {"userName":$('#userName').val()},
        type: "GET",
        dataType: "json",
        success: function (jsonObj) {
          console.log(jsonObj.msg);
          //设置用test(),获取用val()??
          $("#usrHint").text(jsonObj.msg);
          if (jsonObj.state == 0) {
            $("#usrHint").attr("class", "msg-success");
          } else {
            $("#usrHint").attr("class", "msg-error");
          }
        }
      });

    });


  $("#userName").focus(function (){
    this.nextElementSibling.innerHTML = '用户名长度在6到9位之间';
    this.nextElementSibling.className = 'msg-default';
  })
  $("#password").focus(function(){
    this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
    this.nextElementSibling.className = 'msg-default';
  })
  $("#password").blur(function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '密码不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码长度在尽量别少于6位');
    }else {
      this.nextElementSibling.innerHTML = '密码格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    }
  })


  $("#upwdconfirm").focus(function(){
    this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
    this.nextElementSibling.className = 'msg-default';
  })
  $("#upwdconfirm").blur(function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '密码不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码长度在尽量别少于6位');
    }else {
      this.nextElementSibling.innerHTML = '密码格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    }
  })
  
  /*3.对邮箱地址进行验证*/
  $("#email").blur(function(){
      console.log("123");
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '邮箱不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('邮箱不能为空');
    }else if(this.validity.typeMismatch){
      this.nextElementSibling.innerHTML = '邮箱格式不正确';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('邮箱格式不正确');
    }else {
      this.nextElementSibling.innerHTML = '邮箱格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');

      var data =$("#email").val();
      if(!data){   //用户没有输入任何内容
        return;
      }
      /**发起异步GET请求，询问服务器邮箱是否已经存在**/
      $.ajax({
          "url":"checkEmail.do",
          "data":{"email":$('#email').val()},
          "type":"GET",
          "dataType":"json",
          "success":function (jsonObj) {
              console.log(jsonObj.state);
              $("#email_hint").text(jsonObj.msg);
              if(jsonObj.state == 0){
                  $("#email_hint").attr("class", "msg-success");
              } else {
                  $("#email_hint").attr("class", "msg-error");
              }
          }
      })

    }

    return;
  });


  $("#email").focus(function(){
    this.nextElementSibling.innerHTML = '请输入合法的邮箱地址';
    this.nextElementSibling.className = 'msg-default';
  });
  /*3.对手机号进行验证*/
  $("#phone").blur(function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '手机号不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号不能为空');
    }else if(this.validity.patternMismatch){
      this.nextElementSibling.innerHTML = '手机号格式不正确';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号格式不正确');
    }else {
        this.nextElementSibling.innerHTML = '手机号格式正确';
        this.nextElementSibling.className = 'msg-success';
        this.setCustomValidity('');

        var data = document.getElementById("phone").value;
        if (!data) {   //用户没有输入任何内容
            return;
        }
        /**发起异步GET请求，询问服务器用户名是否已经存在**/
        $.ajax({
            "url":"checkPhone.do",
            "data":{"phone":$("#phone").val()},
            "type":"GET",
            "dataType":"json",
            "success":function (jsonObj) {
                $("#phone_hint").text(jsonObj.msg);

                if (jsonObj.state == 0){
                    $("#phone_hint").attr("class", "msg-success");
                } else {
                    $("#phone_hint").attr("class", "msg-error");
                }
            }
        })
    }
  })

  $("#phone").focus(function(){
    this.nextElementSibling.innerHTML = '请输入合法的手机号';
    this.nextElementSibling.className = 'msg-default';
  })
  
  function register() {
      var count = 0;
      $(".form-group").each(function () {
          if ($(this).find('span').hasClass('msg-error')){
              return false;//return false实现break的功能 ; return 实现continue的功能
          }
          count++;
      })

      if (count < 6){
          console.log("error count:"+count);
          return;
      }

      $.ajax({
          "url":"handle_register.do",
          "data":$("#form-register").serialize(),//可以通过高科技的方式给后端传值
          "type":"POST",
          "dataType":"json",
          success:function (jsonObj) {
              alert(jsonObj.state);
              alert(jsonObj.msg);

              if (jsonObj.state >= 0){
                  window.location.href = "login.do"
              } else {
                  alert("注册失败");
              }

          }
      })

      return;
  }
</script>
</body>
</html>