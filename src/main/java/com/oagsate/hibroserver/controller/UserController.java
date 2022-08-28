package com.oagsate.hibroserver.controller;

import com.oagsate.hibroserver.controller.utils.R;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
