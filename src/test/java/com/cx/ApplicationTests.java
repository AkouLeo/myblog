package com.cx;

import com.cx.entity.User;
import com.cx.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }

}
