# CADERNO LAB 2.4

## Wrapping-up & integrating concepts

 - Criação de um serviço da web (API REST) usando o Jakarta EE
 - Objetivo (fornecer citações aleatórias de filmes ou programas de TV)
 - O serviço deve oferecer três endpoints:
    - GET api/quote: Este endpoint retorna uma citação aleatória de qualquer show ou filme (o show não é especificado).
    - GET api/shows: Este endpoint retorna uma lista de todos os shows ou filmes para os quais existem citações. Cada show ou filme deve ter um identificador ou código associado.
    - GET api/quotes?show=<show_id>: Este endpoint retorna todas as citações existentes para o show ou filme especificado pelo "show_id".

## Codigo

### QuoteResource.java

- Controlador principal que lida com as solicitações da API
- @RestController do Spring Boot indica que esta classe é um controlador REST
- @GetMapping do Spring Boot define endpoints acessíveis por meio de solicitações HTTP GET.
- Endpoints disoníveis:
    - api/quote
    - api/shows
    - api/quotes?show=<show_id>

### Quote.java

- Classe que representa uma citação de um filme ou programa de TV
- Tem atributos Id, show e quote

### Show.java

- Classe que representa um filme ou programa de TV
- Tem atributos Id e show

## RESUMO

- Este exercício é um exemplo de como criar uma API REST com Jakarta EE para fornecer recursos como citações de filmes e programas de TV. Pode ser usado como base para construir um serviço mais complexo com Jakarta EE, adequado para uma variedade de cenários.





