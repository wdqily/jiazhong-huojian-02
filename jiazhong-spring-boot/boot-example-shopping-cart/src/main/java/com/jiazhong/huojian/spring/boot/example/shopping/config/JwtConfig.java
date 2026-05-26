package com.jiazhong.huojian.spring.boot.example.shopping.config;

import com.jiazhong.huojian.spring.boot.example.shopping.bean.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Date;


public class JwtConfig {
    //常量
    public static final long EXPIRE = 1000 * 60 * 60 * 24; //token过期时间
    public static final String APP_SECRET = "1234"; //秘钥，加盐

    //	@param id 当前用户ID
    //	@param issuer 该JWT的签发者，是否使用是可选的
    //	@param subject 该JWT所面向的用户，是否使用是可选的
    //	@param ttlMillis 什么时候过期，这里是一个Unix时间戳，是否使用是可选的
    //	@param audience 接收该JWT的一方，是否使用是可选的
    //生成token字符串的方法
    public static String getJwtToken(Users user) {

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")    //头部信息
                .setHeaderParam("alg", "HS256")    //头部信息
                //下面这部分是payload部分
                // 设置默认标签 7个标签(我这里只写了3个)
                .setSubject("walker")    //设置jwt所面向的用户
                .setIssuedAt(new Date())    //设置签证生效的时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))    //设置签证失效的时间
                .setAudience("张三")
                //自定义的信息，这里存储id和姓名信息
                .claim("id", user.getId())  //设置token主体部分 ，存储用户信息
                .claim("name", user.getNickname())
                //下面是第三部分
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();
        // 生成的字符串就是jwt信息，这个通常要返回出去
        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * 直接判断字符串形式的jwt字符串
     *
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 解析JWT
     *
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwt).getBody();
        return claims;
    }
}
