package cn.highedu.cat.service;

import cn.highedu.cat.pojo.dto.UserLogDTO;
import cn.highedu.cat.pojo.vo.JwtVO;
import cn.highedu.cat.pojo.vo.UserLogInfoVO;

public interface UserLogService {
    JwtVO login(UserLogDTO userLogDTO);
}
