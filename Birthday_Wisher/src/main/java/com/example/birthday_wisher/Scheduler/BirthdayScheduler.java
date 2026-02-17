package com.example.birthday_wisher.Scheduler;

import com.example.birthday_wisher.Service.BirthdayService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BirthdayScheduler {

    private final BirthdayService birthdayService;

    public BirthdayScheduler(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @Scheduled(cron = "0 * * * * ?")
    void sendMails()
    {
        System.out.println("Birthday scheduler is running");
        try
        {
            birthdayService.processBirthday();
        }
        catch (Exception e)
        {
            System.out.println("Birthday scheduler failed" +  e.getMessage());
        }


    }
}
