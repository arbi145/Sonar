FROM maven as build
WORKDIR /app
COPY . .
RUN mvn install

FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/achat-1.0.jar /app/
CMD ["java","-jar","/achat-1.0.jar"]