# Workshop MongoDB

## Sobre o projeto

Projeto desenvolvido no Workshop MongoDB, organizado pela Devsuperior

## Tecnologias utilizadas
- Java
- Spring Boot
- JPA
- Maven
- MongoDB
- Docker


## Pré-requisitos 

### Container Docker do MongoDB

```bash
docker run -d -p 27017:27017 -v /data/db --name mongo1 mongo:4.4.3-bionic
```

```bash
docker exec -it mongo1 bash

```
