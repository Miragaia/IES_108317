# CADERNO LAB 2.3 (demo3)

## Codigo

### Demo3Application

- @SpringBootApplication: Marca a classe principal do aplicativo como uma classe de configuração do Spring Boot. Configura automaticamente a aplicação Spring Boot e inicia a execução da aplicação quando chamamos SpringApplication.run(Demo3Application.class, args) no método main.

### GreetingController

- @RestController: Marca a classe como um controlador REST, indicando que os métodos deste controlador irão responder a solicitações HTTP com JSON.

- @GetMapping("/api/greeting"): Define o mapeamento do método greeting para o endpoint /api/greeting com um método GET. Isso significa que quando uma solicitação GET é feita para /api/greeting, o método greeting será chamado.

greeting: Este é o método que lida com a solicitação. Aceita um parâmetro name, que pode ser passado na URL da solicitação. Cria uma mensagem de saudação personalizada com base no nome fornecido ou, se nenhum nome for fornecido, utiliza "World". Em seguida, cria uma instância da classe Greeting com a mensagem e a retorna como resposta.

### Greeting

- Greeting: Esta classe representa a resposta JSON que será enviada pelo endpoint REST. Possui um campo message e um construtor para definir esse campo. Além disso, possui um método getMessage para acessar o valor do campo message.

### Resumo

- Cria uma aplicação Spring Boot que possui um controlador REST simples que responde a solicitações GET em /api/greeting com mensagens de saudação em formato JSON. O nome é um parâmetro opcional que pode ser fornecido na URL.

