package com.core.base.task;

import com.core.base.enums.DateStyleEnum;
import com.core.base.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author smallTao.liu
 * @version V1.0
 * @description
 * @date 2018/6/29 10:11
 */
@Component
public class SchedulerTask {

    private int count = 0;

    private Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    //    @Scheduled(cron = "*/5 * * * * ?")
    private void task1() {
        logger.info("task1 info：" + count++ + " " + DateUtil.dateToString(new Date(), DateStyleEnum.YYYY_MM_DD_HH_MM_SS));
    }

    //    @Scheduled(fixedRate = 7000)
    private void task2() {
        logger.info("现在时间：" + DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

}
