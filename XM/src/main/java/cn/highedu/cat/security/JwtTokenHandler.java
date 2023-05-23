package cn.highedu.cat.security;

import cn.highedu.cat.common.ServiceCode;
import cn.highedu.cat.common.ServiceException;
import cn.highedu.cat.pojo.vo.UserLogInfoVO;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Slf4j
@Service
public class JwtTokenHandler {
    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.duration-in-minute}")
    private long durationInMinute;
    public JwtTokenHandler() {
        log.debug("JwtTokenHandler对象创建");
    }
    /**
     * 将UserDetailsImpl对象转换为JWT字符串
     */
    public String createToken(UserDetailsImpl userDetails){
        UserLogInfoVO userLogInfoVO = userDetails.getUserLogInfoVO();
        return createToken(userLogInfoVO);
    }
   /* *//**
     * 将JWT字符串解析为UserDetailsImpl对象
     *//*
    public UserDetailsImpl parseJwtToken(String jwt){
        UserLogInfoVO adminLoginInfoVO = parseToken(jwt);
        return new UserDetailsImpl(adminLoginInfoVO);
    }*/
    /**
     *将 AdminLoginInfoVO 对象转换为 JWT 字符串
     * */
    public String createToken(UserLogInfoVO userLogInfoVO) {
        log.debug("开始创建JWT，参数：{}", userLogInfoVO);
        // 从 AdminLoginInfoVO 对象中获取数据
        String subject = userLogInfoVO.getUsername();
        Date now = new Date();
        Date exp = new Date(now.getTime() + durationInMinute * 60 * 1000);
        Long id = userLogInfoVO.getId();
        String jwt = Jwts.builder()
                // 设置 JWT 的标准信息
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(exp)
                // 设置 JWT 的载荷
                .claim("id", id)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        log.debug("创建JWT成功，结果：{}", jwt);
        return jwt;
    }
    /*public UserLogInfoVO parseToken(String jwt) {
        log.debug("开始解析JWT，参数：{}", jwt);
        try {
            // 解析 JWT 字符串
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwt)
                    .getBody();
            // 从 JWT 字符串中获取数据
            Long id = Long.valueOf(claims.get("id").toString());
            String username = claims.get("sub").toString();
            // 创建 AdminLoginInfoVO 对象
            UserLogInfoVO userLogInfoVO = new UserLogInfoVO();
            userLogInfoVO.setId(id);
            userLogInfoVO.setUsername(username);

            log.debug("解析JWT成功，结果：{}", userLogInfoVO);
            return userLogInfoVO;
        } catch (ExpiredJwtException e) {
            log.error("JWT已过期", e);
            throw new ServiceException(ServiceCode.ERR_JWT_EXPIRED, "JWT已过期");
        } catch (SignatureException e) {
            log.error("解析JWT失败", e);
            throw new ServiceException(ServiceCode.ERR_JWT_SIGNATURE, "令牌无效");
        } catch (Exception e) {
            log.error("解析Token失败", e);
            log.error("解析JWT失败", e);
            throw new ServiceException(ServiceCode.ERR_JWT_MALFORMED, "令牌无效");
        }
    }*/
}
