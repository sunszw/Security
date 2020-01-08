package com.security.service.impl;

import com.security.entity.User;
import com.security.exception.*;
import com.security.mapper.UserMapper;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void regUser(User user) {
        User result = userMapper.findUserByName(user.getUsername());
        if (result != null) {
            throw new UsernameRepeatException("用户名已存在,请重新修改!");
        }

        LocalDateTime now = LocalDateTime.now();

        user.setCreDate(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Integer row = userMapper.insertUser(user);
        if (row != 1) {
            throw new InsertException("未知错误,注册失败!");
        }
    }

    @Override
    public User login(String username, String password) {
        User result = userMapper.findUserByName(username);
        if (result == null) {
            throw new UserNotFoundException("用户不存在!");
        }
        if (!result.getPassword().equals(password)) {
            throw new PasswordNotMatchException("密码错误!");
        }
        return result;
    }

    @Override
    public void delUserById(Integer id) {
        User user = userMapper.findUserById(id);
        if (user == null) {
            throw new UserNotFoundException("用户不存在!");
        }
        Integer row = userMapper.deleteUserById(id);
        if (row != 1) {
            throw new DeleteUserException("删除时出现未知错误，请稍后重试!");
        }
    }

    @Override
    public void changeUserByUsername(String username, String password) {
        User user = userMapper.findUserByName(username);
        if (user == null) {
            throw new UserNotFoundException("用户不存在!");
        }
        Integer row = userMapper.updateUserByUsername(username,password);
        if (row != 1) {
            throw new UpdateException("修改时出现未知错误，请稍后重试!");
        }
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = userMapper.findAllUser();
        if (users == null) {
            throw new FindUserException("查询时出现未知错误，请稍后重试!");
        }
        return users;
    }


}
