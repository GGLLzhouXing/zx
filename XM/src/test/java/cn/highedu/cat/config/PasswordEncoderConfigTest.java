package cn.highedu.cat.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class PasswordEncoderConfigTest {
@Autowired
PasswordEncoder passwordEncoder;
    @Test
    void passwordEncoder() {
        String password = "123456";
        String encodePassword=passwordEncoder.encode(password);
        log.debug("加密后的密码:{}",encodePassword);
    }
}