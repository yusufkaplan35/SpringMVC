package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration //anotasyonu bulunduğu sınıfın Spring için bir
                //konfigürasyon sınıfı olduğunu, bu sınıf içinde bir veya birden
                // fazla bean tanımlaması yapılabileceğini belirtir.
@ComponentScan("com.tpe") //bu package daki tüm componentları tarama işlevini gerçekleştirir.
                        //defaultta: com.tpe(AppConfiguration classının bulunduğu package)
@PropertySource("classpath:application.properties") //properties dosyasının uygulama içinde kaynak olarak erişilmesini sağlar
public class AppConfiguration {

    //Environment: Springin interface i; properties uzantılı dosya içindeeki key/value lara ulaşmamızı sağlar.
                // Aynı zamanda uygulamanın çalıştığı sistemdeki ortam değişkenlerine de ulaşabilir.
    @Autowired
    private Environment environment; //sistemin çalıştığı çevre değişkenlerine de ulaşıyor.
                                    //propertiesi okuması için yaptık



    //thirdParty classlardan bean oluşturulmasını istersek @Bean annotation kullanılır. Method seviyesinde kullanılır
    @Bean
    public Random random(){
        return new Random();
    }

    //value annotationu ile yaptığımızı Javanın içerisinde yer alan Proeperties classı ile de yapabiliriz.
    //Properties --> HashTable extend eden bir classtır.

    @Bean
    public Properties properties(){
        Properties properties=new Properties();  //oluşturduğumuz objeyi bean yaptık
        properties.put("mymail",environment.getProperty("app.email"));
        properties.put("myphone",environment.getProperty("app.phone"));

        return properties;
    }

}
