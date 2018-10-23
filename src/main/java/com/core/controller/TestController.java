package com.core.controller;

import com.alibaba.fastjson.JSON;
import com.core.base.result.PageResult;
import com.core.base.result.Result;
import com.core.dao.repository.TestRepository;
import com.core.entity.Test;
import com.core.service.Receiver;
import com.core.service.Sender;
import com.core.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/14 9:41
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestService testService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    /*@Autowired
    private DiscoveryClient discoveryClient;*/

    @GetMapping(value = "")
    @RequiresPermissions("test:list")
    public Result<PageResult> test(int pageNum, int pageSize) {
        PageResult pageResult = new PageResult(testRepository.findAll(PageRequest.of(pageNum - 1, pageSize)));
        return new Result<PageResult>().success(pageResult);
    }

    @GetMapping(value = "/name/{name}")
    @ApiOperation(value = "测试返回页面", notes = "调用接口，返回html页面")
    public List<Test> findByName(@PathVariable(value = "name") String name) {
        return testRepository.findByName(name);
    }

    @GetMapping(value = "/uid/{uid}")
    public Test getTest(@PathVariable(value = "uid") String uid) {
        return testService.getTest(uid);
    }

    @GetMapping(value = "/{pageNum}/{pageSize}")
    public Result<PageResult<Test>> getList(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return new Result<PageResult<Test>>().success(testService.getList(pageNum, pageSize));
    }

    @GetMapping(value = "/sendMail")
    public Result<List<Test>> sendMail(String name) {
        List<Test> result = testRepository.findByName(name);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("smalltao.liu@qq.com");
        simpleMailMessage.setTo("532438041@qq.com");
        simpleMailMessage.setSubject("SpringBoot Mail Test");
        simpleMailMessage.setText(JSON.toJSONString(result));

        javaMailSender.send(simpleMailMessage);
        return new Result<List<Test>>().success(result);
    }

    @GetMapping(value = "/sendMsg")
    public Result sendMsg() {
        sender.send();
        return new Result().success();
    }

    /*@GetMapping(value = "/eureka", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result testEureka() {
        return new Result().success("Services:" + discoveryClient.getServices());
    }*/

}
