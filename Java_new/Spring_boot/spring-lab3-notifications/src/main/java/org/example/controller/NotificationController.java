package org.example.controller;
import org.example.service.MessageService;
import org.example.service.NotificationManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
//    private final ApplicationContext context;
    private final NotificationManager notificationManager ;

//    public NotificationController(ApplicationContext context) {
//        this.context = context;
//    }

    public NotificationController (NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

//    @GetMapping("/notify")
//    public String notify(@RequestParam String message, @RequestParam String recipient) {
////        NotificationManager manager = context.getBean(NotificationManager.class);
////        manager.notify(message, recipient);
//        notificationManager.notify(message, recipient);
//        return "Уведомление отправлено через аннотации";
//    }

    @GetMapping("/notify")
    public String notify(@RequestParam String message,
                         @RequestParam String recipient,
                         @RequestParam(defaultValue = "emailService") String serviceType) {
        notificationManager.notify(message, recipient, serviceType);
        return "Уведомление отправлено через " + serviceType;
    }
}