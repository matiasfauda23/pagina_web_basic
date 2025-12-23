# 1. Etapa de Construcción (Build)
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# 2. Etapa de Ejecución (Run) - ACÁ CAMBIAMOS LA IMAGEN
# Usamos eclipse-temurin que es la recomendada actualmente
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]