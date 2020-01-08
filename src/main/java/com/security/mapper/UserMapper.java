package com.security.mapper;

import com.security.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    Integer insertUser(User user);

    User findUserByName(String username);

    List<User> findAllUser();

    Integer deleteUserById(Integer id);

    Integer updateUserByUsername(@Param("username") String username, @Param("password") String password);

    User findUserById(Integer id);


}
