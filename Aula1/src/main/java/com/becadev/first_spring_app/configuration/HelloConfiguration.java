package com.becadev.first_spring_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// classes de configuration servem para conferir bins e instancias de classes no contexto de uma aplicação spring
// pq as vezes precisamos que o spring faça a injenção de uma classe externa de outra biblioteca que nao está dentro do spring, pra isso é criado uma classe de configuração
@Configuration // indica para o spring que ele deve usar a class como base de configuração
public class HelloConfiguration {
    //@Bean // ela é usada dentro das classes de @configuration para ele usar esse metodo como bin, dai ele vai mapear todos que tem bean, dai se algum momento for requisito algumas dessas classes ele vai saber
    //public SDKAWS sdkAWS(){
    //    return new SDKAWS();
    //}
}
