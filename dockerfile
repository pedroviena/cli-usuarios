
FROM openjdk:17-slim
WORKDIR /app
COPY target/cli-usuarios-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]