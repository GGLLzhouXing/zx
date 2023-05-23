package cn.highedu.cat.controller;

import cn.highedu.cat.common.JsonResult;
import cn.highedu.cat.service.CheckYzmService;
import cn.highedu.cat.service.UserRegService;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@Api("验证码")
@RestControllerAdvice
@RequestMapping("/happycaptcha")
@Slf4j
public class HappyCaptchaController {
    //用来产生验证码
    @GetMapping("/verifyCode")
    public void generateImage(HttpServletRequest request, HttpServletResponse response){

        HappyCaptcha.require(request,response)
                .style(CaptchaStyle.ANIM)
                .type(CaptchaType.NUMBER)
                .build().finish();
    }
    @Autowired
    CheckYzmService yzmService;
    @PostMapping ("/checkYzm")
    public JsonResult<Void> checkYzm(@RequestBody String yzm, HttpServletRequest request){
        log.debug("开始处理核实验证码的请求,参数：{}",yzm);
        boolean result= HappyCaptcha.verification(request,yzm,true);
        yzmService.checkYzm(result);
            return JsonResult.ok();

    }
}
