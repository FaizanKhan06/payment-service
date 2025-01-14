FROM openjdk:17-oracle
COPY ./target/payment-service-0.0.1-SNAPSHOT.jar payment-service.jar
CMD ["java","-jar","payment-service.jar"]