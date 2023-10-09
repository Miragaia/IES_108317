# CADERNO LAB 2.3 (demo2)

## Codigo

### Demo2Application

- Ponto de entrada de uma aplicação Spring Boot
- A anotação "@SpringBootApplication" marca esta classe como uma classe de configuração do Spring Boot e indica que este é uma aplicação Spring Boot.
- SpringApplication.run(Demo2Application.class, args);. Isso inicia a aplicação Spring Boot, configurando todos os componentes e serviços necessários para a sua execução

### GreetingController

- Controlador Spring que lida com solicitações relacionadas a greetings
- A anotação @Controller indica que é um componente controlador Spring.
- O método greeting é mapeado para a URL "/greeting" por meio da anotação @GetMapping("/greeting"). Isso significa que quando uma solicitação GET é feita para "/greeting", este método será chamado.
- O método aceita parâmetros da solicitação, como "name" e "customMessage", usando a anotação @RequestParam. Esses parâmetros podem ser passados na URL da solicitação.
- Os valores são colocados no Model através de model.addAttributr(...)
- Retorna um String "greeting", que corresponde ao nome de uma página de modelo (template) a ser renderizada. Isso permite que o controlador envie dados para a página de modelo "greeting" para que sejam exibidos ao utilizador.

### Resources

- Foram criados 2 ficheiro HTML, greeting e index para suportar as respostas aos pedidos de forma a mostrar algo ao utilizador