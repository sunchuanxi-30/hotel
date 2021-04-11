package com.dareway.hotel.hotel.service;

import com.dareway.hotel.hotel.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserByName(String userName);
    List<User> getAllUser();
    User selectUserByName(String userName);
    Boolean deleteByuserId(Integer userId);
    User findUserById(Integer userId);
    User findUserByUserName(String userName);
}
