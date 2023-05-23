package cn.highedu.cat.service.impl;

import cn.highedu.cat.pojo.dto.UserLogDTO;
import cn.highedu.cat.pojo.vo.JwtVO;
import cn.highedu.cat.pojo.vo.UserLogInfoVO;
import cn.highedu.cat.security.JwtTokenHandler;
import cn.highedu.cat.security.UserDetailsImpl;
import cn.highedu.cat.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserLogServiceImpl implements UserLogService {
    @Autowired
    JwtTokenHandler jwtTokenHandler;
    @Autowired
    AuthenticationManager authenticationManager;
    @Override
    public JwtVO login(UserLogDTO userLogDTO) {
        //利用认证管理器手动认证
        //1.创建认证对象, 传入用户名和密码
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userLogDTO.getUsername(),
                        userLogDTO.getPassword());
        //2.调用认证管理器的authenticate方法, 传入认证对象（用户名和密码）
        Authentication authenticationResult = authenticationManager.authenticate(token);
        //3.认证成功后，将认证信息存入上下文，这样就完成了认证
        //  Spring安全上下文，存储了认证信息，就表示认证成功，认证信息就是Authentication对象
        //  相反，如果没有存储认证信息，就表示没有认证成功！这一点很重要！
        SecurityContextHolder.getContext().setAuthentication(authenticationResult);
        //获取认证的主体 principal
        Object principal = authenticationResult.getPrincipal();
        //认证主体实际是UserDetails的实现类 UserDetailsImpl
        UserDetailsImpl userDetails = (UserDetailsImpl) principal;
        //4.认证成功后，生成token
        String tokenString = jwtTokenHandler.createToken(userDetails);
        //5.将token返回给客户端
        return new JwtVO(tokenString);
    }

}
