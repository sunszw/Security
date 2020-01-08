package com.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.security.entity.User;
import com.security.exception.PasswordNotMatchException;
import com.security.exception.UserNotFoundException;
import com.security.exception.UsernameRepeatException;
import com.security.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void testReg() {
        User user = new User();
        user.setUsername("beach");
        user.setPassword("asdasd");
        user.setGender(0);
        try {
            userService.regUser(user);
        } catch (UsernameRepeatException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("OK");
    }

    @Test
    public void testLogin() {
        User user = null;
        try {
            user = userService.login("fkall", "asdasd");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (PasswordNotMatchException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(user);

    }



    @Test
    public void testTime() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        System.out.println(LocalDateTime.of(2020, Month.JANUARY, 1, 8, 0, 0));
        System.out.println(time.format(DateTimeFormatter.ISO_DATE));
        System.out.println(LocalDateTime.parse("2020--01--02 11:21", DateTimeFormatter.ofPattern("yyyy--MM--dd HH:mm")));

    }


}
