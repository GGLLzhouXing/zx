package cn.highedu.cat.controller;

import cn.highedu.cat.common.JsonResult;
import cn.highedu.cat.pojo.dto.UserLogDTO;
import cn.highedu.cat.pojo.dto.UserRegDTO;
import cn.highedu.cat.pojo.vo.JwtVO;
import cn.highedu.cat.service.UserLogService;
import cn.highedu.cat.service.UserRegService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    UserLogService userLogService;
    @Autowired
    UserRegService userRegService;
    @GetMapping("/login")
    public JsonResult<Void>login(@RequestBody UserLogDTO userLogDTO){
        log.debug("开始处理【用户登录】的请求，参数：{}", userLogDTO);
        //JwtVO jwtVO =userLogService.login(userLogDTO);
       return JsonResult.ok();
    }
    @PostMapping("/register")
    public JsonResult <Void>register(@RequestBody UserRegDTO userRegDTO){
        log.debug("开始执行【保存用户】的请求,参数:{}",userRegDTO);
        userRegService.addUser(userRegDTO);
        return JsonResult.ok();
    }


}
