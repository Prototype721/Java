package org.example.config;

import org.example.service.EmailService;
import org.example.service.NotificationManager;
import org.example.service.PushService;
import org.example.service.SmsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan ("org.example")
@ComponentScan ("org.example.controller")
public class AppConfig {

//    @Bean
//    public EmailService emailService() {
//        return new EmailService();
//    }
//
//    @Bean
//    public SmsService smsService() {
//        return new SmsService();
//    }
//
//    @Bean
//    public PushService pushService() {
//        return new PushService();
//    }
//
//    @Bean
//    public NotificationManager notificationManager() {
//        // ЯВНО указываем, какой бин внедряем
//        return new NotificationManager(emailService());
//    }
}