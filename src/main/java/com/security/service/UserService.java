package com.security.service;


import com.security.entity.User;

import java.util.List;

public interface UserService {

    void regUser(User user);

    User login(String username,String password);

    void delUserById(Integer id);

    void changeUserByUsername(String username, String password);

    List<User> getAllUser();





}
