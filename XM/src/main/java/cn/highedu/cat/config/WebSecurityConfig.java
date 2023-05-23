package cn.highedu.cat.config;

//import cn.highedu.cat.security.JwtTokenAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 加密
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        log.debug("配置委托密码编辑器");
        return new BCryptPasswordEncoder();
    }

    //@Autowired
    //private JwtAuthenticationFilter jwtAuthenticationFilter;

    //@Autowired
    //private JwtTokenAuthenticationEntryPoint jwtTokenAuthenticationEntryPoint;

    /**
     * 声明 AuthenticationManager 对象，提供认证服务
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * 配置HTTP请求的认证规则
     * 配置Spring Security的Filter链，以及相关的安全配置
     * @param http HTTP请求的认证规则
     * @throws Exception 异常
     */

}


