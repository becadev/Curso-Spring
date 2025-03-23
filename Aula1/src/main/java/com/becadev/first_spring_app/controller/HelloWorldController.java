package com.becadev.first_spring_app.controller;
// classes que irá fazer as requisições http para os clientes da aplicação

import com.becadev.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

@RestController // combina as anotações de controller e responsebody(json, xml)
@RequestMapping("/hello-world") // passa um parametro para mostrar qual request eu quero mapear, e escuta todas as requisições que chegam ao endpoint /hello-world
public class HelloWorldController {
    @Autowired  // * vai indicar que essa dependencia aqui tem que ser injetada (injeção de dependencia)
    private HelloWorldService helloWorldService;
    // outra forma de fazer sem precisar de construtor *
    //public HelloWorldController(HelloWorldService helloWorldService) {
     //   this.helloWorldService = helloWorldService;
    //}

    // esse metodo pode responde todos os metodos de HTTP: post, get, delete, put, patch, options, head, em cima da classe precisa especifica qual metodo sera utilizado
    @GetMapping // esse metodo irá responder as requisições GET /hello-world
    public String helloWorld() {
        return helloWorldService.helloWorld("Nity");
    }

    //@PostMapping // quando alguem enviar uma requisação para nosso endpoint
    //public String helloWorldPost(@RequestBody SecurityProperties.User body) { // recebe os valores que o cliente mandou no body da requisição, declarando o parametro com uma anotação
      //  return "Hello World" + body.getName();
    //}
    // é comum receber o id do usuario por exemplo
    //para indicar para o spring q a gnt quer pegar essa url :
    @PostMapping("/{id}") // quando alguem enviar uma requisação para nosso endpoint
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value ="filter", defaultValue = "nenhum") String filter, @RequestBody SecurityProperties.User body) { // recebe os valores que o cliente mandou no body da requisição, declarando o parametro com uma anotação
       // return "Hello World" + body.getName() + id;
        return "Hello World" + body.getName() + filter;
    } // pathvariavle : extraia valores da url


}
