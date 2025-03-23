package com.becadev.first_spring_app.service;
import org.springframework.stereotype.Service;

// Classe de service costumam ser classes de serviço que contém a alogica da aplicação, toda a regra de negocios de como deve funcionar
// o controller recebe as requisições que serão passadas para a class service
@Service
public class HelloWorldService {
    public String helloWorld(String name){
        return "hello Wold!" + name;
    }
}
