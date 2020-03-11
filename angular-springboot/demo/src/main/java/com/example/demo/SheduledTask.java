package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableScheduling
public class SheduledTask {


//    In this case, the duration between the end of last execution and the start of next execution is fixed.
//    The task always waits until the previous one is finished.
//    This option should be used when it’s mandatory that the previous execution is completed
//    before running again.
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }


//    This option should be used when each execution of the task is independent.
//    Note that scheduled tasks don't run in parallel by default. So even if we used fixedRate,
//    the next task won't be invoked until the previous one is done.
//    If we want to support parallel behavior in scheduled tasks,
//    we need to add the @Async annotation:
    AtomicInteger atomicInteger=new AtomicInteger();
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        System.out.println(
                "Fixed rate task async - "+atomicInteger.incrementAndGet()+" " + System.currentTimeMillis() / 1000);

        final String uri = "https://raw.githubusercontent.com/ishanRox/Virtusa-Training/master/ds";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
m();
        System.out.println(result);
        Thread.sleep(2000);
    }


    public void m(){
        System.out.println("ishan vimukthi");
    }
}
