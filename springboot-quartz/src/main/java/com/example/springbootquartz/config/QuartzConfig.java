package com.example.springbootquartz.config;

import com.example.springbootquartz.task.MjtTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: ljl
 * @Date: 2018/11/29 16:31
 * @Description:
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(MjtTask.class).withIdentity("mjtTask").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");

        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("mjtTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
