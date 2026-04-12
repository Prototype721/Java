package org.example.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class NotificationManager {
//    private final AdvancedMessageService messageService;
//
//    @Autowired
//    public NotificationManager(AdvancedMessageService messageService) {
//        this.messageService = messageService;
//    }

//    private final List<MessageService> messageService;
    private final Map<String, MessageService> messageServices;

//    @Autowired
//    public NotificationManager(@Qualifier("customEmail") MessageService messageService) {
//        this.messageService = messageService;
//    }

//    @Autowired
//    public NotificationManager(List<MessageService> messageService) {
//        this.messageService = messageService;
//    }

    @Autowired
    public NotificationManager(Map<String, MessageService> messageService) {
        this.messageServices = messageService;
    }

//    public void notify(String message, String recipient) {
////        messageService.sendMessage(message, recipient);
//        messageService.forEach(service -> service.sendMessage(message, recipient));
//    }


    public void notify(String message, String recipient, String serviceType) {
        MessageService service = messageServices.get(serviceType);
        if (service != null) {
            service.sendMessage(message, recipient);
        } else {
            System.out.println("Сервис типа " + serviceType + " не найден");
        }
    }
}