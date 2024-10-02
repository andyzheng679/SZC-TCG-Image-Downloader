# Step 1: Build the Spring Boot application
FROM openjdk:17-slim AS build
WORKDIR /app

# Copy everything from the current directory to the container's working directory
COPY . .

# Give execute permission to the Maven wrapper
RUN chmod +x ./mvnw

# Build the application using the Maven wrapper
RUN ./mvnw clean package

# Step 2: Use a smaller image to run the JAR file
FROM openjdk:17-slim
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port Spring Boot will run on
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
