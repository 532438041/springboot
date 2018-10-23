package com.core.base.config;

import com.core.base.result.Result;
import com.core.base.result.ResultEnum;
import com.core.base.utils.ToolsUtil;
import com.core.dao.repository.SysLogRepository;
import com.core.entity.SysLog;
import com.google.common.base.Throwables;
import org.apache.shiro.authz.AuthorizationException;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description 异常统一处理
 * @date 2018/6/19 11:17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private SysLogRepository sysLogRepository;

    /**
     * 404异常
     *
     * @param req
     * @param rsp
     * @param ex
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handle404Exception(HttpServletRequest req, HttpServletResponse rsp, NoHandlerFoundException ex) {
        return handleError(req, rsp, null, ex, ResultEnum.NOT_FOUND, "");
    }

    /**
     * 处理所有异常
     *
     * @param req
     * @param rsp
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(HttpServletRequest req, HttpServletResponse rsp, HandlerMethod handlerMethod, Exception ex) {
        ResultEnum resultEnum = ResultEnum.INTERNAL_SERVER_ERROR;
        String msg = "";
        if (ex instanceof MethodArgumentNotValidException) {
            // 处理所有接口数据验证异常
            resultEnum = ResultEnum.BAD_REQUEST;
        } else if (ex instanceof ServiceException) {
            // 业务失败的异常
            resultEnum = ResultEnum.NOT_IMPLEMENTED;
        } else if (ex instanceof AuthorizationException) {
            resultEnum = ResultEnum.UNAUTHORIZED;
            msg = "无访问权限";
        }
        return handleError(req, rsp, handlerMethod, ex, resultEnum, msg);
    }

    /**
     * 保存异常日志
     *
     * @param req
     * @param rsp
     * @param ex
     * @param resultEnum
     * @return
     */
    private Result handleError(HttpServletRequest req, HttpServletResponse rsp, HandlerMethod handlerMethod, Exception ex, ResultEnum resultEnum, String msg) {
        SysLog sysLog = new SysLog();
        sysLog.setUid(ToolsUtil.getUUID());
        sysLog.setCreateBy(ToolsUtil.getCookie(req, "userId"));
        sysLog.setCreateTime(new Date());
        sysLog.setDetails(req.getRequestURI());
        sysLog.setReqIp(req.getRemoteAddr());
        sysLog.setLogType("ex异常");
        if (handlerMethod != null) {
            sysLog.setMethod(handlerMethod.getBeanType().getName() + "." + handlerMethod.getMethod().getName() + "()");
        }
        sysLog.setExCode(resultEnum.getCode().toString());
        if (ToolsUtil.isNotTrimNull(msg)) {
            sysLog.setExMsg(msg);
        } else {
            sysLog.setExMsg(ex.getMessage());
        }
        sysLog.setExDetail(Throwables.getStackTraceAsString(ex));
        // 保存日志
        logger.error(ex.getMessage(), ex);
        sysLogRepository.save(sysLog);
        return new Result().failed(resultEnum.getCode(), sysLog.getExMsg());
    }

}
