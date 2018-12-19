package lq.study.springboot.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 测试定时任务
 */
@Component
public class RetryTask {

    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    // 定义每过3秒执行任务
//    @Scheduled(fixedRate = 3000)
//	@Scheduled(cron = "4-40 * * * * ?")
    @Scheduled(initialDelay = 5*1000,fixedRate = 10*1000)
    public void testTask(){
        System.out.println("定时任务:"+LocalDateTime.now().format(DATE_TIME_FORMATTER));
    }

}
