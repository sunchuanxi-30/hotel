package com.dareway.hotel.hotel.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class TokenUtil {
    private static final long EXPIRE_TIME = 15 * 60 * 1000;         // 设置过期时间为15分钟
    private static final String TOKEN_SECRET = "JNVCOR&$@)_(#VSZ+_?CV}{XNVM^&";  // 设置签名私钥
    /**
     * 生成token，可以将你认为需要的数据当成参数存入
     */
    public static String sign(String userName,String password) {
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<String, Object>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userName", userName)
                    .withClaim("password",password)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 检验token是否正确语句
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 获取token中的参数值
     * @param token
     * @return
     */
    public static String getUserName(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        }catch (Exception e){
            return null;
        }

    }
    /**
     * 获取token中的参数值
     * @param token
     * @return
     */
    public static String getPassword(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("password").asString();
        }catch (Exception e){
            return null;
        }

    }
    public static String getTokenUserId(){
        String token =   getRequest().getHeader("token");
        String userId = JWT.decode(token).getAudience().get(0);
        return userId;

    }
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes ==null?null:requestAttributes.getRequest();
    }

}

