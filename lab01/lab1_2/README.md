# CADERNO LAB 1.2

## Estrutura de um Projeto Maven

### Gerenciamento de Build com o Maven

O Maven não é apenas uma ferramenta de gerenciamento de dependências, mas também uma poderosa ferramenta de gerenciamento de build. Isso significa que o Maven simplifica todo o processo de construção de um projeto, desde a compilação até a criação de artefatos distribuíveis, como JARs, WARs ou outros tipos de pacotes.

#### Exemplo de POM.xml para Gerenciamento de Build Básico

Aqui está um exemplo simples de um arquivo `pom.xml` que define o ciclo de vida do build para um projeto Java:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.exemplo</groupId>
    <artifactId>meu-projeto</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

## Exemplo para correr o projeto
    
    ```bash
        1º: mvn package

        2º: java -cp .\target\my_weather_radar-1.0-SNAPSHOT.jar com.ies.WeatherStarter 1160900  
    ```