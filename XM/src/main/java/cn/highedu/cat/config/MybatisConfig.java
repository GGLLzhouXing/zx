package cn.highedu.cat.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.highedu.cat.mapper")
public class MybatisConfig {

}
