# Secure-Pseudo-Queue
A Spring boot application, based on queue type microservices architecture, for encrypting and decrypting the JSON data received from HTTP request. Technologies used to build this microservice based application are, Spring Boot(Web, Cloud, JPA) and H2 In-memory database.

The "secure-pseudo-queue-sender" application is an API to where POST request is routed from a gateway and encrypted. The port used is 8081.

The "secure-pseudo-queue-receiver" application is an API to where encrypted POST request's body(JSON data) is sent and on receiving end the body gets decrypted and stored in a database. The port used is 8082.

The "secure-pseudo-queue-service-registry" application is a registry service for the all the services present in this microservices application. Eureka server is the underlying technology. The port used is default 8761.

The "secure-pseudo-queue-gateway" application is a gateway service for the APIs mentioned above. This acts as a common gateway and router for all the services present in this microservice application. The port used is 8083.


To achieve microservices functionality, the above services should be deployed in the order, "secure-pseudo-queue-service-registry" -> "secure-pseudo-queue-sender" -> "secure-pseudo-queue-receiver" -> "secure-pseudo-queue-gateway".

On a local machine, the default POST url is "localhost:8083/sender/post" and the default GET url is "localhost:8083/receiver/get".
