package com.dareway.hotel.hotel.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.dareway.hotel.hotel.annotation.PassToken;
import com.dareway.hotel.hotel.annotation.UserLoginToken;
import com.dareway.hotel.hotel.model.User;
import com.dareway.hotel.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request,  HttpServletResponse response, Object handle) throws Exception {
        String token = request.getHeader("token");
        String loginUserId = request.getHeader("loginUserId");
        if(!(handle instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handle;
        Method method = handlerMethod.getMethod();
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if(passToken.required()){
                return true;
            }
        }
        if(method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if(userLoginToken.required()){
                if(token == null){
                    throw new RuntimeException("无Token,请重新登录");
                }
                String userId;
                try{
                    userId = JWT.decode(token).getAudience().get(0);
                }catch (JWTDecodeException e){
                    throw new Exception("token验证未通过");
                }
                if(!userId.equals(loginUserId)){
                    throw new Exception("用户已登出");
                }
                User user = userService.findUserById(Integer.valueOf(userId));
                if(user == null){
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try{
                    jwtVerifier.verify(token);
                }catch (JWTVerificationException e){
                    throw  new RuntimeException("");
                }
                return true;
            }
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
