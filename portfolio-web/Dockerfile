# 1. Usamos una imagen con Maven y Java 17 para compilar el proyecto
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. Usamos una imagen liviana solo con Java 17 para ejecutarlo
FROM openjdk:17-jdk-slim
COPY --from=build /target/portfolio-web-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]