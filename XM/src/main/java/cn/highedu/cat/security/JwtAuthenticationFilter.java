package cn.highedu.cat.security;

import cn.highedu.cat.common.JsonResult;
import cn.highedu.cat.common.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT认证过滤器
 * 1. 从请求头中获取jwtToken
 * 2. 解析jwtToken，获取用户信息
 * 3. 将token中的用户信息存入SecurityContext，完成利用jwtToken认证
 * 实际上是将用户信息存入SecurityContext中，恢复认证状态
 * 从而完成利用Token认证
 * 4. 放行
 * 5. 由于是OncePerRequestFilter，所以会在每次请求时都执行
 * 但是由于SecurityContext中已经有了（恢复了）用户信息，所以不会再次执行认证
 * 也就是说，只要用户登录成功，就可以在一段时间内不用再次登录
 */
/*@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenHandler jwtTokenHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        //获取请求头中的token
        String jwtToken = request.getHeader("Authorization");
        log.debug("jwtToken: {}", jwtToken);
        if (jwtToken == null) {
            //放行,不需要认证,不需要授权 例如登录 注册 验证码等
            filterChain.doFilter(request, response);
            return;
        }

        try {
            //从token中获取用户信息
            UserDetailsImpl userDetails = jwtTokenHandler.parseJwtToken(jwtToken);
            log.debug("userDetails: {}", userDetails);
            //将用户信息存入SecurityContext

            //创建UsernamePasswordAuthenticationToken对象作为认证结果
            Authentication authenticationResult =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());
            // 将UsernamePasswordAuthenticationToken存入SecurityContext
            // 从而完成利用Token认证
            SecurityContextHolder.getContext().setAuthentication(authenticationResult);
            //放行
            filterChain.doFilter(request, response);
        }catch (ServiceException e){
            //token无效
            log.debug("token无效");
            //响应错误信息
            response.setContentType("application/json;charset=utf-8");
            JsonResult<Void> jsonResult = JsonResult.fail(e);
            String json = jsonResult.toJson();
            response.getWriter().println(json);
        }
    }
}*/
