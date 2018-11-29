package com.example.springbootquartz.task;

import com.example.springbootquartz.feign.TestService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @Auther: ljl
 * @Date: 2018/11/29 16:29
 * @Description:
 */

public class MjtTask extends QuartzJobBean {

    @Autowired
    TestService testService;

    private static Logger log = LoggerFactory.getLogger(MjtTask.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("开始定时计时{}:{}", LocalDateTime.now(), testService.index());
    }
}
