package com.oagsate.hibroserver.controller;

import com.oagsate.hibroserver.controller.utils.FileUploadUtil;
import com.oagsate.hibroserver.controller.utils.R;
import com.oagsate.hibroserver.domain.Image;
import com.oagsate.hibroserver.domain.Thought;
import com.oagsate.hibroserver.domain.User;
import com.oagsate.hibroserver.service.ImageService;
import com.oagsate.hibroserver.service.ThoughtService;
import com.oagsate.hibroserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private UserService userService;

//    @GetMapping
//    public R getAll() {
//
//        return new R(0, thoughtService.getAll());
//    }
//
//    @GetMapping("/getByUid/{uid}")
//    public R getByUid(@PathVariable int uid) {
//        List<Map> ret = thoughtService.getByUid(uid);
//        return new R(0, ret);
//    }
//
//    @PostMapping
//    public R register(@RequestBody Thought param, HttpSession session) {
//        R r = new R();
//        Date date = new Date();// 获取当前时间
//        param.setCreateTime(date.toString());
//        User user = (User) session.getAttribute("user");
//        param.setUid(user.getId());
//        thoughtService.save(param);
//        return r;
//    }

    @PostMapping
    public R upload(@RequestParam("image") MultipartFile multipartFile, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        String uploadDir = "images/" + user.getId();
        String fileName = UUID.randomUUID().toString();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        Image img = new Image();
        img.setName(fileName);
        img.setType(0);
        imageService.save(img);
        user.setAvatar(fileName);
        userService.updateById(user);
        session.setAttribute("user", user);
        R r = new R();
        r.setData(fileName);
        return r;
    }
//
//    @DeleteMapping
//    public R delete(@RequestParam int id) {
//        boolean res = thoughtService.removeById(id);
//        R r = new R();
//        if (!res) {
//            r.setCode(2);
//        }
//        return r;
//    }
}
