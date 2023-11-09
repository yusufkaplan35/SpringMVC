package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MyApplication {
    public static void main(String[] args) {

        Message messsage = new Message();
        messsage.setBody("Spring ile çalışmak harika");

        //config sınıfını okur, component scan ile belirtilen tüm componentları tarar
        //herbirinden sadece 1 tane bean oluşturur, context hazır bekletir.
        //bean istendiğinde eğer bu objenin bağımlılığı varsa içine enjekte eder ve verir.

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        //mesaj mailservice ile gönderilsin
        // MailService service = new MailService();

    //    MessageService service = context.getBean(MailService.class); //biz obje oluşturmadık, rica ettik
        //MessageService service = context.getBean(MessageService.class); // Spring akıllı
     //   service.sendMessage(messsage); //service: spring bean

     //   MessageService service2= context.getBean(SmsService.class);
     //   service2.sendMessage(messsage);

        //MessageService service = context.getBean(MessageService.class);// implement edilen iki classta çağırılırsa
                                                                         // mutlaka belirtilmesi gerekir

     //   MessageService service3 = context.getBean("sms_service",MessageService.class);
     //  service3.sendMessage(messsage);

        //interface i implemente eden birden fazla class olduğunda
        //getBean methodu ile context ten interface ile birlikte bean istediğimizde
        //bean in çeşidini (ismini) belirtmeliyiz.

  //     System.out.println("*************** Bağımlılık sonrası *************");
  //     MessageService service4 = context.getBean(MailService.class);
  //     service4.saveMessage(messsage);

        //random objesi 1 kere Spring tarafından oluşturulsa ve tüm uygulamada
        //aynı objeyi kullansak, Nasıl?


   //     Random random = context.getBean(Random.class);
   //     System.out.println(random.nextInt(10));

        SmsService service5=context.getBean(SmsService.class);
        service5.saveMessage(messsage);
    //    service5.printContact();
        service5.printProperties();


        //bean scope
        //singleton: default
        //tüm uygulama boyunca sadece 1 tane bean oluşturulur
        //beanin lifecycleından tamamen spring sorumludur

        //prototype
        //her istekte yeni bir bean oluşturulur
        //beanin imha edilmesinden spring sorumlu değildir

        MessageService service6=context.getBean(MailService.class);
        MessageService service7=context.getBean(MailService.class);


        if (service6==service7){
            System.out.println("Aynı objeler");
            System.out.println(service6);
            System.out.println(service7);
        }else {
            System.out.println("Farklı objeler");
        }

        context.close(); // scope u singleton olan beanleri imha ediyor.

    }

}
