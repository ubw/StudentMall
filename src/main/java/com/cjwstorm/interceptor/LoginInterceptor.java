package com.cjwstorm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登陆的拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        //判断session中是否有uid
        if (request.getSession().getAttribute("uid") == null) {
            System.out.println("未登陆,重定向到主页去");
            String url = request.getContextPath()+"/main/index.do";
            response.sendRedirect(url);
            return  false;
        }
        System.out.println("已登陆,uid="+Integer.valueOf(request.getSession().getAttribute("uid").toString()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
