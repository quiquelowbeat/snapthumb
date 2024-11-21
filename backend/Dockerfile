FROM openjdk:17-jdk-slim

ARG JAR_FILE

WORKDIR /thumbnailgenerator

COPY backend/target/${JAR_FILE} thumbnailgenerator.jar

EXPOSE 8080 5005

ENTRYPOINT ["java", "-jar", "thumbnailgenerator.jar"]