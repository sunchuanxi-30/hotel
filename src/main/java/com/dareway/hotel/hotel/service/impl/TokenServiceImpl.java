package com.dareway.hotel.hotel.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dareway.hotel.hotel.model.User;
import com.dareway.hotel.hotel.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(User user) {
            Date start = new Date();
            long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
            Date end = new Date(currentTime);
            String token = "";

            token = JWT.create().withAudience(String.valueOf(user.getUserId())).withIssuedAt(start).withExpiresAt(end)
                    .sign(Algorithm.HMAC256(user.getPassword()));
            return token;
    }
}
