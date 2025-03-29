package com.becadev.formulario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class FormularioController {
    @GetMapping("/home")
    public ModelAndView home() { // serve para que informe que essa classe é a responsavel por fazer o mapeamento do que ta na logica do negocio e mandar para o thymeleaf
        ModelAndView mv = new ModelAndView("index"); // passa o nome do arquivo html
        String titulo1 = "Do back ao front";
        String p1 = "programação fullstack";
        String nome1 = "Rebeca Linda";
        ArrayList<String> nomes = new ArrayList<String>();
        nomes.add("rebeca");
        nomes.add("linda");
        nomes.add("sempre");
        nomes.add("obvio");
        nomes.add("amo");
        mv.addObject("titulo", titulo1); // o titulo1 daqui vai ser exibido no titulo do index.html
        mv.addObject("p", p1);
        mv.addObject("nome", nome1);
        mv.addObject("listaDeNomes", nomes);
        return mv; // quando alguuem acessar /home, ele vai criar o ModelAndview e enviar
    }
    @PostMapping("/formulario")
    public ModelAndView form(String email) { // não precisar ser necessariamente modelAndview, porem como eu quero mostrar na tela entao vai ser modelandvies
        ModelAndView mv = new ModelAndView("formulario"); // pagina formulario
        mv.addObject("email", email);
        System.out.println(email);
        return mv;
    }
}
