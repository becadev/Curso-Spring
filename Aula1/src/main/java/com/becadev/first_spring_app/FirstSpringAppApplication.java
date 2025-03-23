package com.becadev.first_spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// o spring vai fazer injenção de referencias das classes do projeto
@SpringBootApplication // td framework é configurado por meio de anotações, esse arroba ele abstrai configurações que será carregada na class
// essa anotação que define a porta de entrada do springboot concentrando as anotações a seguir:
//@Configuration // vai definir que a classe pode ter metodo que define bins
//@EnableAutoConfiguration // ativa a autoconfigurações do spring
//@ComponentScan // permite que scaneie td o pacote do projeto em bnusca dos componentes
// @Profile("dev")
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

}
