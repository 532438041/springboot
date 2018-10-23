package com.core.controller;

import com.core.base.result.Result;
import com.core.base.utils.ToolsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/28 11:27
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/set")
    public Result setValue(String name, String msg) {
        redisTemplate.opsForValue().set(name, msg);
        return new Result().success(redisTemplate.opsForValue().get(name));
    }

    @GetMapping("/get")
    public Result getValue(String name) {
        return new Result().success(redisTemplate.opsForValue().get(name));
    }

    @GetMapping("/setUid")
    public Result setUid(HttpSession httpSession) {
        String uid = ToolsUtil.getUUID();
        if (ToolsUtil.isNotNull(httpSession.getAttribute("uid"))) {
            uid = httpSession.getAttribute("uid").toString();
        }
        httpSession.setAttribute("uid", uid);
        return new Result().success(httpSession.getId());
    }


}
