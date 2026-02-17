package com.example.birthday_wisher.Service.ServiceImpl;

import com.example.birthday_wisher.Entity.User;
import com.example.birthday_wisher.Repository.UserRepo;
import com.example.birthday_wisher.Service.BirthdayService;
import com.example.birthday_wisher.Service.EmailService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BirthdayServiceImpl implements BirthdayService {

    private final UserRepo userRepo;
    private final EmailService emailService;

    public BirthdayServiceImpl(UserRepo userRepo, EmailService emailService) {
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @Override
    public void processBirthday() {
        System.out.println("Birthday service started");

        LocalDate today =  LocalDate.now();
        int day =  today.getDayOfMonth();
        int month = today.getMonthValue();

        List<User> user = userRepo.findUsersByDayAndMonth(day, month);

        if(user.isEmpty())
        {
            System.out.println("User with today's birthday not found");
            return;
        }

        for(User u:user)
        {
            try{
                emailService.sendMailOfWish(u.getEmail(), u.getName());
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
