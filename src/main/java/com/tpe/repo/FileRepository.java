package com.tpe.repo;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class FileRepository implements Repository{
    @Override
    public void save(Message message) {
        System.out.println("Mesaj dosyaya kaydedildi. Mesaj : "+message.getBody());
    }
}
