package com.core.controller;

import com.core.base.result.Result;
import com.core.base.result.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/7/9 10:31
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login")
    public Result login(String userName, String userPwd) {
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPwd);
        try {
            subject.login(token);
            return result.success(subject.getSession().getId(), "登录成功");
        } catch (UnknownAccountException ex) {
            return result.failed(ResultEnum.BAD_REQUEST.getCode(), "帐号不存在");
        } catch (IncorrectCredentialsException ex) {
            return result.failed(ResultEnum.BAD_REQUEST.getCode(), "帐号或密码错误");
        } catch (LockedAccountException ex) {
            return result.failed(ResultEnum.BAD_REQUEST.getCode(), "登录失败，该用户已被冻结");
        } catch (Exception ex) {
            return result.failed();
        }
    }

    @GetMapping(value = "/unauth")
    public Result unauth() {
        return new Result().failed(ResultEnum.UNAUTHORIZED.getCode(), "无访问权限");
    }


}
