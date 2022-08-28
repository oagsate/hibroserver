package com.oagsate.hibroserver.dao;

import com.oagsate.hibroserver.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
        User user=new User();
        user.setLocation(3);
        user.setHeight(174);
        user.setWeight(50);
        user.setEmail("abc@sss.com");
        user.setDescription("setetet");
        userDao.insert(user);
    }
}
