package com.core.controller;

import com.core.base.result.Result;
import com.core.dao.repository.SysLogRepository;
import com.core.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description
 * @author smallTao.liu
 * @date 2018/6/21 9:22
 * @version V1.0
 */
@RestController
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogRepository sysLogRepository;

    @GetMapping("")
    public Result<List<SysLog>> getList() {
        return new Result<List<SysLog>>().success(sysLogRepository.findAll());
    }

}
