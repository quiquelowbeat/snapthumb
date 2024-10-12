FROM openjdk:17.0.1-jdk-slim

ARG JAR_FILE

WORKDIR /thumbnailgenerator

COPY target/${JAR_FILE} thumbnailgenerator.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "thumbnailgenerator.jar"]