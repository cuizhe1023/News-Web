package com.zemic.user.test;

import com.zemic.user.UserApplication;
import com.zemic.user.model.request.LoginRequest;
import com.zemic.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class TestDB {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        try {
            LoginRequest request = new LoginRequest();
            request.setMobile("18234147072");
            request.setPassword("1");
            System.out.println(userService.login(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
