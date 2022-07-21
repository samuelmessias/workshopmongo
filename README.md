# workshopmongo
Projeto Spring Boot | MongoDB

Container Docker do MongoDB

docker run -d -p 27017:27017 -v /data/db --name mongo1 mongo:4.4.3-bionic

docker exec -it mongo1 bash
