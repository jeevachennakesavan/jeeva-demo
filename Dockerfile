# Use a base image with Java and Maven
FROM maven:3.8.6-openjdk-11 AS build

# Set working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the project (Skipping tests to avoid failures in CI/CD)
RUN mvn clean package 

# Use a minimal Java runtime image
FROM openjdk:11-jre-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose any necessary ports (if applicable)
EXPOSE 8080  # Change if needed

# Run the application
CMD ["java", "-jar", "app.jar"]
