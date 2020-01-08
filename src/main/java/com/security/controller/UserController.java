package com.security.controller;


import com.security.entity.User;
import com.security.json.Json;
import com.security.service.UserService;
import com.security.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("reg")
    public Json<Void> reg(User user) {
        userService.regUser(user);
        return new Json<>(SUCCESS);
    }

    @ResponseBody
    @PostMapping("login")
    public Json<User> login(@RequestParam("username") String name, @RequestParam("password") String pwd) {
        User user = userService.login(name, pwd);
        return new Json<>(SUCCESS, user);
    }

    @ResponseBody
    @GetMapping("findall")
    public Json<java.util.List<User>> findAllUser() {
        java.util.List<User> users = userService.getAllUser();
        return new Json<>(SUCCESS, users);
    }

    @ResponseBody
    @GetMapping("{id}/del")
    public Json<Void> delUser(@PathVariable("id") Integer id) {
        userService.delUserById(id);
        return new Json<>(SUCCESS);
    }

    @ResponseBody
    @PostMapping("change")
    public Json<Void> changeUser(String username,String password) {
        userService.changeUserByUsername(username,password);
        return new Json<>(SUCCESS);
    }


    @ResponseBody
    @GetMapping("vercode")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession session = req.getSession();
        session.setAttribute("index_code", text);
        VerifyCode.output(image, resp.getOutputStream());
    }


}
