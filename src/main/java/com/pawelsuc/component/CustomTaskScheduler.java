package com.pawelsuc.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class CustomTaskScheduler {

    //    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedDelay = 5000)
//    sekunda, minuta, godzina, dzień miesiąca, miesiąca, dzień tygodnia
    @Scheduled(cron = "${cron.expression}")
    public void doSomeStuff() {
//        Thread.sleep(1000);
        System.out.println("some operation, time: " + LocalTime.now());
    }
}
