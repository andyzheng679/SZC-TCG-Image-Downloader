Dockerfile - blueprint that contains instructions for building a Docker image. Defines environment, dependencies, configuration, and commands needed to create the image.

Image - the result of building a Dockerfile. A template for creating a container.

Container - runnable instance of the image, where the application code executes, each container operates independently. 


FROM openjdk:17-slim AS build : basic Java environment using version 17, slim is lightweight form. Building

WORKDIR /app : sets up a folder called /app, makes it the active location, go to this folder to do the next steps

COPY . . : copies everything from our project folder into the /app

RUN chmod +x ./mvnw : gives permission to the Maven wrapper file to run, file is needed to build the project

RUN ./mvnw clean package : runs the Maven wrapper to build the project, clean removes any previous builds, package creates a .jar file (package version of the app) in/app/target, when the build runs, 
Maven will Maven automatically creates a target subdirectory inside /app


FROM openjdk:17-slim : start a container using lightweight Java environment, this is for running Java programs

WORKDIR /app : sets up a folder called /app, makes it the active location, go to this folder to do the next steps

COPY --from=build /app/target/*.jar /app/app.jar : copies the packaged .jar file that was created in the build to this container, renaming it app.jar

EXPOSE 8080 : opens up port 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"] : ENTRYPOINT tells docker what command to run when the container starts, java calls the Java runtime, -jar tells Java to execute a JAR file directly, 
/app/app.jar is the path to the JAR file.
