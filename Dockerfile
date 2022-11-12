FROM openjdk:8-jdk-alpine
WORKDIR /app
ADD target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java","-jar","achat-1.0.jar"]
