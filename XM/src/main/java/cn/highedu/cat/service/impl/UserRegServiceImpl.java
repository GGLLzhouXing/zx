package cn.highedu.cat.service.impl;

import cn.highedu.cat.common.ServiceCode;
import cn.highedu.cat.common.ServiceException;
import cn.highedu.cat.mapper.UserMapper;
import cn.highedu.cat.pojo.dto.UserRegDTO;
import cn.highedu.cat.pojo.vo.UserRegVO;
import cn.highedu.cat.service.UserRegService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserRegServiceImpl implements UserRegService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public void addUser(UserRegDTO userRegDTO) {
        log.debug("开始处理【用户注册的业务】,参数:{}",userRegDTO);
        String encodePassword = passwordEncoder.encode(userRegDTO.getPassword());
        userRegDTO.setPassword(encodePassword);
        int row=userMapper.addUser(userRegDTO);
        if(row != 1){
            String message="注册用户失败";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_SAVE_FAILED,message);
        }
    }



}
