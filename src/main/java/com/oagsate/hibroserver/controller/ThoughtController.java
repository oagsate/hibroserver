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

    @GetMapping("/getByUid/{uid}")
    public R getByUid(@PathVariable int uid) {
        return new R(0, thoughtService.getByUid(uid));
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

    @DeleteMapping
    public R delete(@RequestParam int id) {
        boolean res = thoughtService.removeById(id);
        R r = new R();
        if (!res) {
            r.setCode(2);
        }
        return r;
    }
}
