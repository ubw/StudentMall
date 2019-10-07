/**
 * Created by yy on 2016/12/15.
 */

$("#leftsidebar_box dt").css({"background-color":" #0AA1ED"});
$(function(){
    $("#leftsidebar_box dd").hide();
    $("#leftsidebar_box .my_order dd").show();
    //所有的dt的绑定事件
    $("#leftsidebar_box dt").click(function(){
        //所有的dt改变css样式
        $("#leftsidebar_box dt").css({"background-color":"#0AA1ED"});
        //触发的这个dt改变成某个颜色
        $(this).css({"background-color": "#0AA1ED"});
        $(this).parent().find('dd').removeClass("menu_chioce");
        $("#leftsidebar_box dt img").attr("src","../images/myOrder/myOrder2.png");
        $(this).parent().find('img').attr("src","../images/myOrder/myOrder1.png");
        $(".menu_chioce").slideUp();
        $(this).parent().find('dd').slideToggle();
        $(this).parent().find('dd').addClass("menu_chioce");
        $(this).parent().siblings().children('dd').slideUp();
    });
})
//分页部分
$(".tcdPageCode").createPage({
    pageCount:6,
    current:1,
    backFn:function(p){

          }
});


