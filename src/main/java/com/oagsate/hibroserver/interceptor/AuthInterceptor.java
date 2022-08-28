package com.oagsate.hibroserver.interceptor;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oagsate.hibroserver.controller.utils.R;
import com.oagsate.hibroserver.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class AuthInterceptor implements HandlerInterceptor {


    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return true;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            response.getWriter().println(objectMapper.writeValueAsString(new R(1)));
            return false;
        }
        //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }
}
