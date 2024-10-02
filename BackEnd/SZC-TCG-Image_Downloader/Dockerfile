# Step 1: Build the application
FROM openjdk:17-slim AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package

# Step 2: Use a smaller image to run the JAR file
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
