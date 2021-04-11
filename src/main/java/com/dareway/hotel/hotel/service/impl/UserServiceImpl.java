package com.dareway.hotel.hotel.service.impl;

import com.dareway.hotel.hotel.service.UserService;
import com.dareway.hotel.hotel.mapper.UserMapper;
import com.dareway.hotel.hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User selectUserByName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    @Override
    public Boolean deleteByuserId(Integer userId) {
        return userMapper.deleteByuserId(userId);
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }
}
