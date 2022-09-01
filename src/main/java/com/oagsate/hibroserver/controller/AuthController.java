package com.oagsate.hibroserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oagsate.hibroserver.controller.utils.R;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController()
@RequestMapping("api")
public class AuthController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(@RequestBody User param, HttpSession session) {
        R r = new R();
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", param.getName());
        query.eq("password", param.getPassword());
        User user = userService.getOne(query);
        if (user == null) {
            r.setCode(2);
            r.setMessage("用户名或密码错误");
            return r;
        }
        user.setLastTime(new Date().toString());
        userService.updateById(user);
        session.setAttribute("user", user);
        r.setData(user);
        return r;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public R logout(HttpSession session) {
        session.removeAttribute("user");
        return new R(0);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public R register(@RequestBody User param, HttpSession session) {
        R r = new R();
        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("name", param.getName());
        User user = userService.getOne(query);
        if (user != null) {
            r.setCode(12);
            return r;
        }
        Date date = new Date();// 获取当前时间
        param.setCreateTime(date.toString());
        param.setLastTime((date.toString()));
        userService.save(param);
        session.setAttribute("user", param);
        r.setCode(0);
        return r;
    }

    @RequestMapping(value = "/self", method = RequestMethod.GET)
    public R self(HttpSession session) {
        User user = (User) session.getAttribute("user");
        R r = new R();
        r.setData(user);
        return r;
    }
}
