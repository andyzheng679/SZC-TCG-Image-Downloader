Dockerfile - blueprint that contains instructions for building a Docker image. Defines environment, dependencies, configuration, and commands needed to create the image.

Image - the result of building a Dockerfile. A template for creating a container.

Container - runnable instance of the image, where the application code executes, each container operates independently. 


FROM node:18-alpine AS build - building, using node:18-alpine which is a lightweight version of Node.js 18 runtime, for faster performace, quicker build times and smaller container sizes

WORKDIR /app - sets up a folder called /app, makes it the active location, go to this folder to do the next steps

COPY package.json ./ - copies the package.json file from local to /app directory

RUN npm install - installing dependencies needed for the react app  

COPY . . - copies everything from our project folder into the /app

RUN npm run build - runs the build script which is npm run build


FROM nginx:alpine - starts build stage using nginx:alpine, nginx is a lightweight web server, handles requests and serves content quickly

COPY --from=build /app/build /usr/share/nginx/html - copies the build folder from the build stage (/app/build) to nginx's default directory (/usr/share/nginx/html)

EXPOSE 80 - exposing port 80 for application use

CMD ["nginx", "-g", "daemon off;"] - running Nginx in the foreground, without daemon, since we want the app to keep running, daemon off will keep the app running, instead of it running in the background, keeping the container alive
