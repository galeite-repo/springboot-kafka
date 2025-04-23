# Stage 1: Build com Maven e Java 11
FROM maven:3.9.4-eclipse-temurin-11 AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime leve com Java 11
FROM eclipse-temurin:11-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
