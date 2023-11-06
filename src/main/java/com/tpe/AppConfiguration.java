package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //anotasyonu bulunduğu sınıfın Spring için bir
                //konfigürasyon sınıfı olduğunu, bu sınıf içinde bir veya birden
                // fazla bean tanımlaması yapılabileceğini belirtir.
@ComponentScan("com.tpe") //bu package daki tüm componentları tarama işlevini gerçekleştirir.
                        //defaultta: com.tpe(AppConfiguration classının bulunduğu package)
public class AppConfiguration {



}
