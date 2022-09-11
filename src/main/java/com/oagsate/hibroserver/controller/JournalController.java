package com.oagsate.hibroserver.controller;

import com.oagsate.hibroserver.controller.utils.R;
import com.oagsate.hibroserver.domain.Journal;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.JournalService;
import com.oagsate.hibroserver.service.ThoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    public R getAll() {

        return new R(0, journalService.getAll());
    }

    @GetMapping("/getByUid/{uid}")
    public R getByUid(@PathVariable int uid) {
        List<Map> ret = journalService.getByUid(uid);
        return new R(0, ret);
    }

    @PostMapping
    public R register(@RequestBody Journal param, HttpSession session) {
        R r = new R();
        Date date = new Date();// 获取当前时间
        param.setCreateTime(date.toString());
        param.setUpdateTime(date.toString());
        User user = (User) session.getAttribute("user");
        param.setUid(user.getId());
        journalService.save(param);
        return r;
    }

    @DeleteMapping
    public R delete(@RequestParam int id) {
        boolean res = journalService.removeById(id);
        R r = new R();
        if (!res) {
            r.setCode(2);
        }
        return r;
    }
}
