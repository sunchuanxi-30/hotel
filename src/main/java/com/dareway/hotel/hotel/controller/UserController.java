package com.dareway.hotel.hotel.controller;

import com.dareway.hotel.hotel.annotation.PassToken;
import com.dareway.hotel.hotel.annotation.UserLoginToken;
import com.dareway.hotel.hotel.model.User;
import com.dareway.hotel.hotel.service.TokenService;
import com.dareway.hotel.hotel.service.UserService;
import com.dareway.hotel.hotel.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/doLogin")
    public Map<String,Object> login(@RequestBody User user, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        User userForBase = new User();
        User userByUserName = userService.findUserByUserName(user.getUserName());
        if(userByUserName==null){
            map.put("code",1);
            map.put("msg","用户名错误,请重新输入");
            return map;
        }
        userForBase.setUserId(userByUserName.getUserId());
        userForBase.setUserName(userByUserName.getUserName());
        userForBase.setPassword(userByUserName.getPassword());
        if(!userForBase.getPassword().equals(user.getPassword())){
            map.put("code",2);
            map.put("msg","登录失败,密码错误!");
            return map;
        }else {
            String token = tokenService.getToken(userForBase);
            map.put("userId",userByUserName.getUserId());
            map.put("userName",userByUserName.getUserName());
            map.put("userRealname",userByUserName.getUserRealname());
            map.put("role",userByUserName.getRole());
            map.put("code",3);
            map.put("msg","登陆成功!");
            map.put("token",token);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return  map;
        }

    }

    @UserLoginToken
    @PostMapping ("/allUser")
    public Map<String,Object> getAllUser(@RequestBody User para){
        Map<String,Object> map=new HashMap<String,Object>();
        String userName = para.getUserName();
        int currentPage = para.getCurrentPage();
        int pageSize = para.getPageSize();
        List<User> allUser;
        if (userName.equals("")) {
            allUser = userService.getAllUser();
        }else {
            allUser = userService.getUserByName(userName);
        }
        if (pageSize*(currentPage - 1)+pageSize<=allUser.size()){
            map.put("data",allUser.subList(pageSize*(currentPage - 1),pageSize*(currentPage - 1)+pageSize));
        }else {
            map.put("data",allUser.subList(pageSize*(currentPage - 1),allUser.size()));
        }
        map.put("totalCount",allUser.size());
        return map;
    };

    @PostMapping("/daleteByuserId")
    public Map<String,Object> deleteByuserId(@RequestBody User para){
        Map<String,Object> map=new HashMap<String,Object>();
        int userId = para.getUserId();
        Boolean res;
        try {
             res = userService.deleteByuserId(userId);
             map.put("result",res);
        }catch (Exception e){
            map.put("result",e);
        }
        return map;
    }
}
