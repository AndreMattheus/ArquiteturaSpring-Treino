package com.github.andremattheus.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void sendMail(String mensagem){
        System.out.println("Enviado email: " + mensagem);
    }
}
