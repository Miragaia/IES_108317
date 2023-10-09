# CADERNO LAB 2.1

## Server-side programming with servlets
 - Um servlet deve ser implementado em um (multithread) Servlet Container para ser utilizado
    - Um Servlet Container é um componente de software que gerencia a execução de servlets Java em aplicações web, processando solicitações HTTP e fornecendo recursos de segurança e multithreading.
    - O Servlet é uma interface genérica em Java, enquanto o HttpServlet é uma classe que estende essa interface, oferecendo implementações padrão para manipular solicitações HTTP, sendo o tipo mais comum de servlet.

## Codigo

### Classe EmbeddedJettyExample
 - Configura um servidor Jetty que ouve na porta 8680.
 - Define um manipulador de servlets para lidar com solicitações HTTP.
 - Inicia o servidor Jetty e aguarda até que seja encerrado.

### Classe HelloServlet
 - Classe interna que estende HttpServlet, que é uma classe base para servlets Java.
 - Implementa a lógica para responder a solicitações HTTP GET.
 - Lê um parâmetro "msg" da solicitação e exibe-o em um cabeçalho <h1> se presente, caso contrário, exibe "New Hello Simple Servlet".

### Resumo
 - Este código Java cria uma aplicação simples usando o servidor Jetty para manipular solicitações HTTP. A classe EmbeddedJettyExample configura o servidor e mapeia o servlet HelloServlet, que responde a solicitações HTTP GET exibindo uma mensagem HTML com base em um parâmetro de consulta "msg" ou exibindo uma mensagem padrão se o parâmetro estiver ausente. O servidor escuta na porta 8680.