# CADERNO LAB 2.2

## Server-side programming and application servers (Tomcat)
 - A programação no lado do servidor e os servidores de aplicação (como o Tomcat) são componentes essenciais no desenvolvimento de aplicações web. O Apache Tomcat, em particular, é um servidor de aplicação amplamente utilizado para hospedar aplicativos web Java, proporcionando um ambiente robusto e escalável para a execução de servlets e JSPs.

## Codigo

 - Implementamos um servlet java que imprime uma mensagem personalizada com base em parâmetros passados na URL.
 - Compilamento/empacotamento do projeto em um arquivo .war
 - Inplantação do arquivo no servidor de aplicação Tomcat dentro de um Docker Container
 - Configuramos o arquivo docker-compose.yml onde mapeamos o diretório de destino local para a pasta padrão de implantação do Tomcat
 - Executamos ao usar "docker-compose up"
 - Confirmamos acedendo a "http://127.0.0.1:8888/JakartaWebStarter-1.0-SNAPSHOT/hello-servlet" 