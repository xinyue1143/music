package com.xiao.music.utils;/**
 * Description: music
 * Created by 28191 on 2021/10/17
 */


import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 *@Classname JwtUtils
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/17 9:58
 *@version 1.0
 */
public class JwtUtils {

    private static long time = 1000*60*60*24;
    private static String signature = "user";

    public static String createToken(String username){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                // payload 载荷
                .claim("username",username)
                .claim("role","user")
                .setSubject("user-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS256,signature)
                .compact();
        return jwtToken;
    }

    public static String parse(String token){
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("username");
    }
}
