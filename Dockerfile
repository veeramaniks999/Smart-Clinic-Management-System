# ---------- Stage 1 : Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and source code, then build
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests clean package

# ---------- Stage 2 : Runtime ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built JAR from the first stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
