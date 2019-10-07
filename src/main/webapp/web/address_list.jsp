<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
    <style type="text/css">
        .dissmiss_popup {
            position:absolute;
            right:1px;
            background:red;
            color:#000;
            text-decoration:none;
            border-radius:3px;
        }

        #mask {
            z-index:1001;
            background:#000;
            position: absolute;
            display:none;
            top:0;
            left:0;
            opacity:0.4;
        }

        #popup_conent {
            padding:10px;
            z-index:1002;
            background:#fff;
            position: absolute;
            display:none;
        }

        #popup_conent h3{
            font-size:16px;
            margin:0px;
            padding:5px 0;
            border-bottom:2px solid #ccc;
        }
    </style>
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
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!--已有地址栏-->
        <div class="address_information_manage">
            <div class="aim_title">
                <span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>
            </div>
            <!--地址列表-->
            <div id="addressList">
                <div class="aim_content_one aim_active">
                    <span class="dzmc dzmc_active">办公室</span>
                    <span class="dzxm dzxm_normal">杨洋</span>
                    <span class="dzxq dzxq_normal">北京市海淀区北下关街道中鼎大厦B座331</span>
                    <span class="lxdh lxdh_normal">18435110514</span>
                    <span class="operation operation_normal">
                            <span class="aco_change">修改</span>|<span class="aco_delete">删除</span>
                        </span>
                    <span class="swmr swmr_normal"></span>
                </div>
                <div class="aim_content_two">
                    <span class="dzmc dzmc_normal">家里</span>
                    <span class="dzxm dzxm_normal">杨洋</span>
                    <span class="dzxq dzxq_normal">北京市大兴区西红门镇瑞海家园</span>
                    <span class="lxdh lxdh_normal">13788882346</span>
                    <span class="operation operation_normal">
                            <span class="aco_change">修改</span>|<span class="aco_delete">删除</span>
                        </span>
                    <span class="swmr swmr_normal" >设为默认</span>
                </div>
            </div>
        </div>
        <div>
            <button type="button" onclick="showPopUp(0)">添加地址</button>
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

<!--遮罩层 要在中间写 除非设置z-index属性 -->
<div id="mask"></div>

<!--上层 要在最后写 除非设置z-index属性-->
<!--z-index属性越小越在底层，越大越在上层-->
<div id="popup_conent">
    <div><a href="#" class="dissmiss_popup" onclick="dismissPopUp()">关闭</a></div>
    <h3>标题</h3>
    <!--收货人信息填写栏-->
    <div class="popup_conent">
        <form method="post" id="addressForm" action="">
            <!--收货人姓名-->
            <div class="recipients">
                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="recvName" id="recvName"/>
            </div>
            <!--收货人所在城市等信息-->
            <div data-toggle="distpicker" class="address_content">
                <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span><select data-province="---- 选择省 ----" id="recvProvince" name="recvProvince" onchange="showCity(-1, -1)"></select>
                城市：<select data-city="---- 选择市 ----" id="recvCity" name="recvCity" onchange="showArea(-1, -1)"></select>
                区/县：<select data-district="---- 选择区 ----" id="recvArea" name="recvArea"></select>
            </div>


            <!--收货人详细地址-->
            <div class="address_particular">
                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="recvAddr" id="recvAddr" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
            </div>
            <!--收货人地址-->
            <div class="address_tel">
                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="recvPhone" name="recvPhone"/>固定电话：<input type="text" name="recvTel" id="recvTel"/>
            </div>
            <!--邮政编码-->
            <div class="address_postcode">
                <span class="red">&nbsp;</span ><span class="kuan">邮政编码：</span>&nbsp;<input type="text" name="recvZip" id="recvZip"/>
            </div>
            <!--地址名称-->
            <div class="address_name">
                <span class="red">&nbsp;</span ><span class="kuan">地址名称：</span>&nbsp;<input type="text" id="recvTag" name="recvTag"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
            </div>
            <!--保存收货人信息-->
            <div class="save_recipient" onclick="addOrUpdateAddress()">
                <input type="hidden" name="id" id="id"/>
                保存收货人信息
            </div>

        </form>
    </div>
</div>

</body>
<!--不再使用distpicker
<script type="text/javascript" src="../js/distpicker111.data.js"></script>
<script type="text/javascript" src="../js/distpicker111.js"></script>
-->
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/jquery.page.js"></script>
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});

    //左侧栏显示收获地址
    $(function(){
        //影藏所有菜单项目
        $("#leftsidebar_box dd").hide();
        //显示收获地址所有菜单项
        $("#leftsidebar_box .address dd").show();
        //所有标题右侧图片箭头为向下
        $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
        //收获地址为向右
        $("#leftsidebar_box .address dt img").attr("src","../images/myOrder/myOrder1.png");

        //显示uid对应的收货地址
        showAddressList();
    });
</script>
<script language="javascript" type="text/javascript">
    var id;
    function showPopUp(actionId){
        //全局变量赋值
        id=actionId;

        //清空表单元素,reset是js自身的函数，不像下面的html()等函数是jquery的。通过选择器选出来的是一个数组，要手动取出找到的元素下标进行js原生操作
        $("#addressForm")[0].reset();

        //设置隐藏域
        $("#id").val(id);
        console.log("隐藏域id的value："+$("#id").val());

        //id=0为增加，其他是修改
        if(id == 0){
            $("#popup_conent h3").html("增加地址");
        } else {
            $("#popup_conent h3").html("修改地址");
        }
        //弹出popup
        var w = 700;
        var h = 400;
        var ww =  window.screen.width;
        var dh =  window.screen.height;
        var wh = $(document).height();

        $("#popup_conent").css({
            "width":w,
            "height":h,
            "left":(ww-w)/2,
            "top":(dh-h)/2
        });
        $("#popup_conent").show();

        //弹出mask
        $("#mask").css("width", ww);
        $("#mask").css("height", wh);
        $("#mask").show();

        //弹出省,选中请选择
        showProvince(-1);

        //新增到此退出
        if (id == 0){
            return;
        }

        $.ajax({
            "url":"../address/get_address.do",
            "data":"id="+id,
            "type":"GET",
            "dataType":"json",
            "success":function (obj) {
                console.log(obj.msg);
                var address = obj.data;
                if (obj.state != 0){
                    alert("获取失败");
                }else{
                    $("#recvName").val(address.recvName);
                    $("#recvAddr").val(address.recvAddr);
                    $("#recvPhone").val(address.recvPhone);
                    $("#recvTel").val(address.recvTel);
                    $("#recvZip").val(address.recvZip);
                    $("#recvTag").val(address.recvTag);
                }
                //ajax中再嵌套ajx也可以
                showProvince(address.recvProvince);
                showCity(address.recvProvince, address.recvCity);
                showArea(address.recvCity, address.recvArea);
            }
        });

        return;
    }

    function showProvince(provinceCode){
        $("#recvProvince").empty();
        $.ajax({
            "url":"../address/province.do",
            "type":"GET",
            "dataType":"json",
            "success":function (jsonObj) {
                var e1 = document.createElement("option");
                e1.innerHTML = "=====请选择=====";
                e1.value = -1;
                document.getElementById("recvProvince").add(e1);
                //将option节点添加到select中去
                document.getElementById("recvProvince").add(e1);
                for (var i = 0; i < jsonObj.data.length; i++){
                    var e = document.createElement("option");
                    //配置option属性,code
                    e.innerHTML = jsonObj.data[i].name;
                    e.value = jsonObj.data[i].code;
                    //将option节点添加到select中去
                    document.getElementById("recvProvince").add(e);
                }
                //显示默认选中的省的Option为provinceCode所指定的。
                $("#recvProvince").val(provinceCode);
            }
        });
    }

    function showCity(provinceCode, cityCode){
        //不传参数为啥取到的省代码是0???????，难道是页面操作比较慢，所以这个时候还是空的？？？很奇怪啊
        var data = "provinceCode=" + $("#recvProvince").val();
        console.log("参数"+data);
        if (cityCode != -1){
            data = "provinceCode=" + provinceCode;
        }
        console.log("参数变形后"+data);
        $("#recvCity").empty();
        $("#recvArea").empty();
        $.ajax({
            "url":"../address/city.do",
            "data":data,
            "type":"GET",
            "dataType":"json",
            "success":function (jsonObj) {
                var e1 = document.createElement("option");
                e1.innerHTML = "=====请选择=====";
                e1.value = -1;
                document.getElementById("recvCity").add(e1);

                //将option节点添加到select中去
                document.getElementById("recvCity").add(e1);
                for (var i = 0; i < jsonObj.data.length; i++){
                    var e = document.createElement("option");
                    //配置option属性,code
                    e.innerHTML = jsonObj.data[i].cityName;
                    e.value = jsonObj.data[i].cityCode;
                    //将option节点添加到select中去
                    document.getElementById("recvCity").add(e);
                }
                //显示默认选中的城市的Option为cityCode所指定的。
                $("#recvCity").val(cityCode);
            }
        });
    }

    function showArea(cityCode, areaCode){
        //不传参数为啥取到的省代码是0???????，难道是页面操作比较慢，所以这个时候还是空的？？？很奇怪啊
        var data = "cityCode=" + $("#recvCity").val();
        console.log("参数"+data);
        if (areaCode != -1){
            data = "cityCode=" + cityCode;
        }
        console.log("参数变形后"+data);

        $("#recvArea").empty();
        $.ajax({
            "url":"../address/area.do",
            "data":data,
            "type":"GET",
            "dataType":"json",
            "success":function (jsonObj) {
                var e1 = document.createElement("option");
                e1.innerHTML = "=====请选择=====";
                e1.value = -1;
                document.getElementById("recvArea").add(e1);

                //将option节点添加到select中去
                document.getElementById("recvArea").add(e1);
                for (var i = 0; i < jsonObj.data.length; i++){
                    var e = document.createElement("option");
                    //配置option属性,code
                    e.innerHTML = jsonObj.data[i].areaName;
                    e.value = jsonObj.data[i].areaCode;
                    //将option节点添加到select中去
                    document.getElementById("recvArea").add(e);
                }
                //显示默认选中的区的Option为areaCode所指定的。
                $("#recvArea").val(areaCode);
            }
        });
    }

    function dismissPopUp(){
        $("#popup_conent").hide();
        $("#mask").hide();
    }

    //新增和提交都走这个
    function  addOrUpdateAddress() {
        var data = $("#addressForm").serialize();
        var url = (id == 0)?"handle_add.do":"update_address.do";

        $.ajax({
            "url":url+"",
            "data":data+"",
            "type":"POST",
            "dataType":"json",
            "success":function (jsonObj) {
                alert(jsonObj.msg);
                //关闭弹出窗口
                dismissPopUp();
                //刷新列表,刷新一遍不成功？可能是因为后台较延时，延时刷新比较好，此处暂时不这么做。
                showAddressList();
                showAddressList();
                showAddressList();
            },
            "error":function (obj) {
                alert("走到error分支");
            }
        });
    }

    //删除地址
    function deleteAddress(id) {
        var ret = confirm("确认删除吗？");
        if (!ret){
            return;
        }

        $.ajax({
            "url":"delete_address.do",
            "data":"id="+id,
            "type":"POST",
            "dataType":"json",
            "success":function (obj) {
                alert(obj.msg);
                if (obj.state == 0){
                    //刷新列表
                    showAddressList();
                }
            }
        });
    }

    //personal.js中调用，调用关系比较乱，暂时不改
   function setDefaultUrl(id) {
        console.log("设置默认地址开始，id"+id);
        $.ajax({
            "url":"set_default.do",
            "data":"id="+id,
            "type":"GET",
            "dataType":"json",
            "success":function (obj) {
                alert(obj.msg);
                //刷新
                showAddressList();
            }
        });
    }
    
    function showAddressList() {
        //html模板
        var htmlTemplate = '<div class="%CSS%">'
            + '<span class="dzmc %CSSTAG%">%TAG%</span>'
            + '<span class="dzxm dzxm_normal">%NAME%</span>'
            + '<span class="dzxq dzxq_normal">%ADDRESS%</span>'
            + '<span class="lxdh lxdh_normal">%PHONE%</span>'
            + '<span class="operation operation_normal">'
            + '<span class="aco_change" id="change%ID%" onclick="showPopUp(%ID%)">修改</span>|'
            + '<span class="aco_delete" id="delete%ID%" onclick="deleteAddress(%ID%)">删除</span>'
            + '</span>'
            + '<span class="swmr swmr_normal" id="setDefault%ID%"  onclick="setDefault(this, %ID%)">设为默认</span>'
            + '</div>';
        //清空列表
        $("#addressList").empty();
        var stringhtml = "";
        //获取列表
        $.ajax({
            "url":"show_address_list.do",
            "type":"GET",
            "dataType":"json",
            "success":function (obj) {
                for(var i = 0; i < obj.data.length; i++){
                    var address = obj.data[i];
                    htmlTemplateTmp = htmlTemplate;
                    //原本的字符串是没有发生变化的，new了一个新的字符串而已必须要加=号
                    htmlTemplateTmp = htmlTemplateTmp.replace("%TAG%", address.recvTag);
                    htmlTemplateTmp = htmlTemplateTmp.replace("%NAME%", address.recvName);
                    htmlTemplateTmp = htmlTemplateTmp.replace("%ADDRESS%", address.recvDistrictProvince+address.recvDistrictCity+address.recvDistrictArea+address.recvAddr);
                    htmlTemplateTmp = htmlTemplateTmp.replace("%PHONE%", address.recvPhone);
                    //正则表达式，匹配所有
                    htmlTemplateTmp = htmlTemplateTmp.replace(/%ID%/g, address.id);

                    //如果是默认地址
                    if(address.defaultAddress == 1){
                        console.log("默认地址的id为:"+address.id);
                        htmlTemplateTmp = htmlTemplateTmp.replace("%CSS%", "aim_content_one aim_active");
                        htmlTemplateTmp = htmlTemplateTmp.replace("%CSSTAG%", "dzmc_active");
                    } else {
                        console.log("id:"+address.id+"不是默认地址，保持原本的模板");
                        htmlTemplateTmp = htmlTemplateTmp.replace("%CSS%", "aim_content_one");
                        htmlTemplateTmp = htmlTemplateTmp.replace("%CSSTAG%", "dzmc_normal");
                    }
                    stringhtml +=  htmlTemplateTmp;
                }
                $("#addressList").html(stringhtml);
            }
        })
    }
</script>
</html>