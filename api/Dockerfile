# Stage 1: Build the application JAR
FROM eclipse-temurin:25-jdk-alpine AS build
WORKDIR /app

# Copy Maven wrapper and pom.xml first to cache dependencies
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copy source code and build the executable JAR (skipping tests for faster image builds)
COPY src src
RUN ./mvnw package -DskipTests

# Stage 2: Lightweight runtime image
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Copy the compiled JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Spring Boot app listens on
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]