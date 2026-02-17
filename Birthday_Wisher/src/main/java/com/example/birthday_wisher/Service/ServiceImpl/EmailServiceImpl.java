package com.example.birthday_wisher.Service.ServiceImpl;

import com.example.birthday_wisher.Service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMailOfWish(String email, String name) {
        System.out.println("Sending email to " + email);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Birthday Wish!!");
        message.setText(
                "Dear " + name + ",\n\n" +
                        "Wishing you a very Happy Birthday! 🎂\n\n" +
                        "Best Regards,\n" +
                        "Your Company"
        );
        try
        {
            mailSender.send(message);
            System.out.println("Email sent to " + email);
        }
        catch (Exception e)
        {
            System.out.println("Error sending email to " + email);
        }

    }
}
