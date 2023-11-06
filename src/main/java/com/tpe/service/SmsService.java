package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component("sms_service") //defaultta: smsService
public class SmsService implements MessageService{

    @Override
    public void sendMessage(Message messsage) {
        System.out.println("Ben bir sms servisiyim. Mesajınız: " + messsage.getBody());
    }

    @Override
    public void saveMessage(Message messsage) {

    }
}
