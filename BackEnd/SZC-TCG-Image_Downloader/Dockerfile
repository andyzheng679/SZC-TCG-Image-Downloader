# Step 1: Build the Spring Boot application
FROM openjdk:17-slim AS build
WORKDIR /app

# Copy the project files into the container
COPY . .

# Ensure the Maven wrapper has execute permission
RUN chmod +x ./mvnw

# Run the Maven build using the wrapper
RUN ./mvnw clean package

# Step 2: Use a smaller image to run the JAR file
FROM openjdk:17-slim
WORKDIR /app

# Copy the built JAR file from the previous build step
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port the Spring Boot app runs on
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
