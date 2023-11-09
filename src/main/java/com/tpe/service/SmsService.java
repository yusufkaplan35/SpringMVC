package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;


@Component("sms_service") //defaultta: smsService
public class SmsService implements MessageService{

    @PostConstruct //obje oluşturulunca metodu çağırır
    public void postConstruct(){
        System.out.println("SmsService objesi oluşturuldu.");
    }

    @PreDestroy // obje imha edilmeden önce metodu çağırır
    public void preDestroy(){
        System.out.println("SmsService objesi imha ediliyoooorr...");
    }



    @Autowired
    @Qualifier("dbRepository")
    private Repository repo;
    @Autowired
    private Random random;


    @Override
    public void sendMessage(Message messsage) {
        System.out.println("Ben bir sms servisiyim. Mesajınız: " + messsage.getBody());
    }

    @Override
    public void saveMessage(Message messsage) {
        //Random random= new Random();
        System.out.println(random.nextInt(10));
        repo.save(messsage);
    }
    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")
    private String phone;

    public void printContact(){
        System.out.println("Email: "+this.email);
        System.out.println("Phone: "+this.phone);
    }
    @Autowired
    private Properties properties;
    public void printProperties(){
        System.out.println("Email bilgisi: "+ properties.getProperty("mymail"));
        System.out.println("Phone bilgisi: "+ properties.getProperty("myphone"));
    }


}
