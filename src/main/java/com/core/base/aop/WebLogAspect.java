package com.core.base.aop;

import com.alibaba.fastjson.JSON;
import com.core.base.utils.ToolsUtil;
import com.core.dao.repository.SysLogRepository;
import com.core.entity.SysLog;
import com.google.common.base.Throwables;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description AOP API请求记录
 * @date 2018/6/19 11:17
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    private SysLogRepository sysLogRepository;

    @Pointcut("execution(public * com.core.controller..*.*(..))")
    public void webLog() {

    }

    @After("webLog()")
    public void doAfter(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    @AfterThrowing(value = "webLog()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        handleLog(joinPoint, ex);
    }

    private void handleLog(JoinPoint joinPoint, Throwable ex) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String logMethod = targetName + "." + methodName + "()";

        Object[] arguments = joinPoint.getArgs();
        StringBuilder params = new StringBuilder();
        if (arguments != null && arguments.length > 0) {
            for (int i = 0; i < arguments.length; i++) {
                // 如果参数为HttpServletResponse 不加入params
                if (("StatHttpServletResponseWrapper").equals(arguments[i].getClass().getSimpleName())) {
                    continue;
                }
                params.append(JSON.toJSONString(arguments[i])).append(";");
            }
        }
        SysLog sysLog = new SysLog();
        sysLog.setUid(ToolsUtil.getUUID());
        sysLog.setLogType("url请求");
        sysLog.setCreateBy(ToolsUtil.getCookie(request, "userId"));
        sysLog.setCreateTime(new Date());
        sysLog.setDetails(request.getRequestURI());
        sysLog.setMethod(logMethod);
        sysLog.setParams(params.toString());
        sysLog.setReqIp(request.getRemoteAddr());
        if (ToolsUtil.isNotNull(ex)) {
            sysLog.setLogType("ex异常");
            sysLog.setExCode(ex.getClass().getName());
            sysLog.setExMsg(ex.getMessage());
            sysLog.setExDetail(Throwables.getStackTraceAsString(ex));
            logger.error(ex.getMessage(), ex);
        }
        // 保存日志
        sysLogRepository.save(sysLog);
    }
}
