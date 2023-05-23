package cn.highedu.cat.security;

import cn.highedu.cat.pojo.vo.UserLogInfoVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
    private UserLogInfoVO userLogInfoVO;

    public UserDetailsImpl(UserLogInfoVO userLogInfoVO) {
        this.userLogInfoVO = userLogInfoVO;
    }
    public UserLogInfoVO getUserLogInfoVO(){return userLogInfoVO;};

    /**
     * 构造方法，将userLogInfoVO对象封装到UserDetailsImpl对象中
     *
     * @param  \
     *              该对象封装了管理员的登录信息
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userLogInfoVO.getUsername();
    }

    @Override
    public String getUsername() {
        return userLogInfoVO.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
