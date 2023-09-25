# CADERNO LAB 1.4

## Introdução ao Docker

O Docker é uma plataforma de virtualização de containers que simplifica o processo de criação, implantação e execução de apps em ambientes isolados e padronizados conhecidos como containers.

### Principais Conceitos do Docker

- **Imagem (Image):** Uma imagem Docker é um pacote executável que inclui todo o necessário para executar um aplicativo, incluindo código, bibliotecas, dependências e configurações.

- **Container:** Um Container Docker é uma instância em execução de uma imagem Docker. Os Container são isolados uns dos outros e da máquina host.

- **Dockerfile:** Um Dockerfile é um arquivo de configuração que define como uma imagem Docker deve ser construída. Ele lista as instruções para instalar software, copiar arquivos e configurar o ambiente.

### Comandos Básicos do Docker

- `docker pull`: Descarrega uma imagem Docker de um repositório, como o Docker Hub.
  
- `docker build`: Constrói uma imagem Docker a partir de um Dockerfile.

- `docker run`: Cria e inicia um novo container a partir de uma imagem. Você pode especificar portas, volumes e outras configurações.

- `docker ps`: Lista todos os containers em execução no sistema.

- `docker stop`: Para a execução de um container em execução.

- `docker rm`: Remove um container.

- `docker images`: Lista todas as imagens disponíveis no sistema.

- `docker rmi`: Remove uma imagem.

- `docker exec`: Executa um comando em um container em execução.

### Exemplo de Uso Básico

Para iniciar um container Ubuntu e executar um terminal interativo:

```bash
    docker run -it ubuntu
```
