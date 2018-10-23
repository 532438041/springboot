package com.core.controller;

import com.core.base.result.Result;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liutao
 * @version V1.0
 * @description
 * @date 2018/8/17 15:38
 */
@RestController
@RequestMapping(value = "/activiti")
public class ActivitiController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessEngine processEngine;

    @GetMapping(value = "/my1")
    public Result my1() {
        logger.info("------myActiviti1 begin--------");
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "smallTao");
        map.put("content", "有事，需要请假！");
        map.put("applyData", LocalDateTime.now());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myActiviti1", map);

        return new Result().success();
    }

    @GetMapping(value = "/list")
    public Result list() {
        List<Task> list = taskService.createTaskQuery().processDefinitionKey("myActiviti1").list();
        List<Map<String, Object>> resultList = new ArrayList<>();

        for (Task task : list) {
            Map<String, Object> map = new HashMap<>();
            ProcessInstance processInstance = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            map.put("id", task.getId());
            map.put("activityId", processInstance.getActivityId());
            map.put("userName", "");
            resultList.add(map);
        }

        return new Result().success(resultList);
    }

}
