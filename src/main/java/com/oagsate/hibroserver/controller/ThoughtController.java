package com.oagsate.hibroserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oagsate.hibroserver.controller.utils.R;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.ThoughtService;
import com.oagsate.hibroserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/api/thought")
public class ThoughtController {

    @Autowired
    private ThoughtService thoughtService;

    @GetMapping
    public R getAll() {
        return new R(0, thoughtService.list());
    }

    @PostMapping
    public R register(@RequestBody Thought param, HttpSession session) {
        R r = new R();
        Date date = new Date();// 获取当前时间
        param.setCreateTime(date.toString());
        User user = (User) session.getAttribute("user");
        param.setUid(user.getId());
        thoughtService.save(param);
        return r;
    }
}
