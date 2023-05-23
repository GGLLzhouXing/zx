/*
package cn.highedu.cat.mapper;

import cn.highedu.cat.pojo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootTest
class UserMapperTest {
@Autowired
UserMapper userMapper;
@Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void addUser() {
        User user=new User("zhangsan","123456","190@qq.com","16823");
        String newpassword =  passwordEncoder.encode(user.getPassWord());
        user.setPassWord(newpassword);
        log.debug("user:{}",user);
    }
}*/
