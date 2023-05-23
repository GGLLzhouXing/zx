package cn.highedu.cat.security;

import cn.highedu.cat.common.JsonResult;
import cn.highedu.cat.common.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT认证失败处理器
 * 1. 未登录时访问受保护资源
 * 2. 认证过程中出现异常
 * 3. 认证成功，但是访问受保护资源时权限不足
 * 目的是解决认证过程中出现的异常 403 状态，改变为返回json数据，ServiceCode.ERR_UNAUTHORIZED
 */
/*@Component
@Slf4j
public class JwtTokenAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        log.debug("JwtTokenAuthenticationEntryPoint.commence() {}", e.getMessage());
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        JsonResult<Void> result = JsonResult.fail(ServiceCode.ERR_UNAUTHORIZED, "请登录后再访问");
        httpServletResponse.getWriter().println(result.toJson());
    }

}*/
