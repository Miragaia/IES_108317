# LAB3_1

## Spring Boot CRUD Application with Thymeleaf

Este projeto é um exemplo de uma aplicação Spring Boot que demonstra a realização de operações CRUD (Criar, Ler, Atualizar, Eliminar) em uma entidade "User" usando o Spring Data JPA, Thymeleaf, e validação de dados.

## Descrição do Código

### User

A classe `User` representa a entidade de User e é mapeada para uma tabela na BD, incluindo validações para campos não vazios.

### UserController

A classe `UserController` é um controlador Spring que lida com as operações relacionadas aos users. 

### UserRepository

Esta interface define métodos para operações de persistência na BD relacionadas à entidade `User`, e é gerenciada pelo Spring.

### DemoApplication

A classe principal da app Spring Boot, que inicia a app e configura as funcionalidades do Spring Boot.


#### Resposta às Perguntas

**1.**: O `UserRepository` é injetado no construtor da classe `UserController` pois a interface `UserRepository` é anotada com `@Repository`. O Spring Framework cuida da instanciação e injeção automática.

**2.**: A classe `UserController` invoca métodos no objeto `userRepository` para realizar operações na BD, como guardar, procurar, atualizar e eliminar usrers. Os métodos incluem `save()`, `findAll()`, `findById()`, e `delete()`. Esses métodos são fornecidos automaticamente pelo Spring Data JPA, são herdados da interface `CrudRepository`, que por sua vez é extendida pelo `UserRepository`.

**3.**: Os dados são salvos em uma BD, que é configurada como um BD H2, adicionada como dependencia do projeto. A classe `User` é anotada com `@Entity`, o que mapeia a entidade para uma tabela na BD. Os métodos do `userRepository` são usados para interagir com essa tabela, permitindo a persistência de dados.

**4.**: A regra para o campo de endereço de e-mail "não vazio" é definida na classe `User`. A anotação `@NotBlank` é usada para garantir que o campo "email" não esteja vazio. Em casos de erro na validação é exibida uma mensagem de erro.

