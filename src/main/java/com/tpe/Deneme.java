package com.tpe;

import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Deneme {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

    public void deneme(){
        MessageService service = context.getBean(MailService.class);

    }
}
