package com.oagsate.hibroserver.controller;

import com.oagsate.hibroserver.controller.utils.R;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public R getAll() {
        return new R(0, userService.list());
    }

    @PutMapping
    public R register(@RequestBody User param, HttpSession session) {
        R r = new R();
        userService.updateById(param);
        User user = userService.getById(param.getId());
        session.setAttribute("user", user);
        r.setData(user);
        return r;
    }

}
