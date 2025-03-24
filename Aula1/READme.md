# Anotações

**RESTful** → A API RESTful é uma interface que dois sistemas de computador usam para trocar informações de forma segura pela internet. A maioria das aplicações de negócios precisa se comunicar com outras aplicações internas e de terceiros para executar várias tarefas. Por exemplo, para gerar contracheques mensais, seu sistema interno de contas precisa compartilhar dados com o sistema bancário de seu cliente a fim de automatizar o faturamento e se comunicar com uma aplicação interna de planilha de horas. As APIs RESTful suportam essa troca de informações porque seguem padrões de comunicação de software seguros, confiáveis e eficientes.

Lombok → biblioteca para escreve menos codigos e gerar coisas automaticas

## Tipos de API:

**Stateless**: a cada nova requisição, voce recebe todas as informações que é preciso para fazer aquela funcionalidade que o cliente está pedindo, vai ta que sempre enviando o login, senha ou token para ter que realizar as requisições, sempre se identificando para a api saber quem ele é, diferente do stateful que mantém ele ja identificado

**Stateful**: mantem dentro dela o estado de cada cliente é mantido  no servidor, o cliente será identificado de alguma forma(por meio de login ou algo do genero), 

Após rodar a aplicação, o **Tomcat** vai indicar a porta que está rodando o endpoint. No meu caso está a porta 8080.
Porta 8080 é padrão

### Para alterar:
resources → application.properties → ”server.port=3000” digita esse comando com a porta que deseja que seja acessada
nesssa pasta de resources tambem sao configuradas a url que o spring vai utilizar para o banco de dados, username para logar no banco…

`spring.application.name=first-spring-appserver.port=3000spring.datasource.url="jdbc:mysql://localhost:3306/first_spring_app//pode colocar também uma variavel de ambiente-->  spring.datasource.url= ${DB_HOST:jdbc:mysql://localhost:3306/first_spring_app"spring.datasource.username=rootspring.datasource.password=root`

que pode injentar na aplicação por meio de docker
O spring também permite configurar perfis de requisição, para poder rodar a aplicação cliente e a aplicação de teste onde o cliente nao vai ter acesso.
Dessa forma voce nao usa  o banco de dados real, mas sim um de teste

``` java
@SpringBootApplication
@ComponentScan 
@Profile("dev")
public class FirstSpringAppApplication {  
public static void main(String[] args) {SpringApplication.*run*(FirstSpringAppApplication.class, args);}
}
```
Testar no navegador:
http://localhost:8080/hello-world

Se tentar acessar uma aplicação que não exista exemplo: [http://localhost:8080/](http://localhost:8080/hello-world)rebecanoemi

ele vai dar um erro gerando uma página de erro genérico. Isso pode ser tratado e retornar esse erro de uma forma amigável. Se deixar do jeito que tá a aplicação fica muito exposta. É interessante tratar a exceção de uma forma mais amigavel para o cliente da nossa api

Teste de uso de filter e id passadas na url: http://localhost:3000/hello-world/uhuhu?filter=rebeca
arquivo json usado para testar a api no postman: 
``` JSON
{ 
"name":"Rebeca",
"[email":"rebeecanoemi494@gmail.com](mailto:email%22:%22rebeecanoemi494@gmail.com)"
}
```
Link da aula: https://youtu.be/YY_hf0FOIcU?si=o_Po1LYkcb5zKU-Z
