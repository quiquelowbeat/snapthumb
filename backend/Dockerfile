FROM maven:3.9.6-eclipse-temurin-17 AS maven-base
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

FROM maven-base AS test
COPY src ./src
RUN mvn verify

FROM maven-base AS quality
COPY src ./src
RUN echo "Running Checkstyle..." && \
    mvn checkstyle:check && \
    echo "Running SpotBugs..." && \
    mvn spotbugs:check && \
    echo "Running PMD..." && \
    mvn pmd:check || (echo "PMD Report:" && cat target/pmd.xml && exit 1)

FROM maven-base AS build
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy AS runtime
WORKDIR /thumbnailgenerator
COPY --from=build /build/target/*.jar thumbnailgenerator.jar
EXPOSE 8080 5005
ENTRYPOINT ["java", "-jar", "thumbnailgenerator.jar"]