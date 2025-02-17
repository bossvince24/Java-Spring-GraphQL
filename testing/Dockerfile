# Use OpenJDK 17 slim as the base image
FROM node:14

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the local project files (assuming your compiled JAR is in the current directory)
COPY package*.json ./ RUN npm install
COPY . .

# Expose the port the application will run on (change if necessary)
EXPOSE 4000 CM

# Command to run the Java application (adjust the file name as needed)
D ["node", "index.js"]