FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build

COPY pom.xml .
RUN mvn dependency:resolve

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /thumbnailgenerator

ARG JAR_FILE

COPY --from=build /build/target/${JAR_FILE} thumbnailgenerator.jar

EXPOSE 8080 5005

ENTRYPOINT ["java", "-jar", "thumbnailgenerator.jar"]