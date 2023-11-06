package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component//bu classın objesinin üretiminden, yönetilmesinden Spring sorumlu olsun.Yani bean oluşturulsun.
public class MailService implements MessageService{
/*
    //field injection
  @Autowired//mail servise repo enjekte edilecek
  @Qualifier("fileRepository") //classın bağlı olduğu repoyu belirtiyoruz.
                              // interface ten bir method çağırdığımızda hangi repoya gideceğini yapması
  private Repository repo;
*/

    //setter injection
    /*
    @Autowired
    @Qualifier("fileRepository")
    private Repository repo;
    public void setRepo(Repository repo) {
        this.repo = repo;
    }
*/
    //constructor injection ==> daha güvenli, daha anlaşılır,test etmek daha kolay

    private Repository repo;
    @Autowired // ==> bean içerisinde başka classın objesine ihtiyaç oluyorsa @Autowired ile enjekte edebiliriz.
    public MailService(@Qualifier("dbRepository") Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajınız : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        //reponun save metoduna erişmek için repo objesi gerekiyor
        //Repository repository=new DbRepository();
        repo.save(message);

    }
}