package com.dareway.hotel.hotel.service;


import com.dareway.hotel.hotel.model.User;

public interface TokenService {
    String getToken(User user);
}
