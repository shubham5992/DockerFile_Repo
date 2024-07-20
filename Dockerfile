# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the Java file into the container
COPY HelloWorldServer.java .

# Compile the Java file
RUN javac HelloWorldServer.java

# Set the command to run the application
CMD ["java", "HelloWorldServer"]

# Expose port 8000 to the outside world
EXPOSE 8000
