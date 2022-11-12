FROM openjdk:8-jdk-alpine
WORKDIR /app
ADD target/achat-1.0.jar achat.jar
ENTRYPOINT ["JAVA","-jar","/achat.jar"]
