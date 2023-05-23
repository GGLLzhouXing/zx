package cn.highedu.cat.service.impl;

import cn.highedu.cat.common.ServiceCode;
import cn.highedu.cat.common.ServiceException;
import cn.highedu.cat.service.CheckYzmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CheckYzmServiceImpl implements CheckYzmService {
    @Override
    public void checkYzm(Boolean result) {
        if (result) {
            log.debug("验证码核实成功");
        } else {
            String message = "验证码核实失败";
            log.debug(message);
            throw new ServiceException(ServiceCode.ERR_BAD_REQUEST, message);
        }
    }
}
