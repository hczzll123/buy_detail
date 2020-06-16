package com.hcz.buy_detail.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dragon-king
 * @createdate 2020/6/15 - 15:32
 */

@Component
public class CreateTimer {

    @Scheduled(cron="0 10 23 * * ?")
    public void start() {


        //每天晚上扫描当天的文件，对当天的文件进行解析

        LocalDateTime localTime = LocalDateTime.now();

        //拿到当天的日期
        String time = localTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));




    }
}
