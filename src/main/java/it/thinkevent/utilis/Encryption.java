package it.thinkevent.utilis;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Encryption {

    @Autowired
    BasicTextEncryptor textEncryptor;

    public String encrypt(String data){
        return textEncryptor.encrypt(data);
    }

    public String decrypt(String data){
        return textEncryptor.decrypt(data);
    }


}
