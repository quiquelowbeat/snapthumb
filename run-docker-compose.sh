#!/bin/bash

mvn clean package -f backend/pom.xml

ARTIFACT_ID=$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout)
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

JAR_FILE="${ARTIFACT_ID}-${VERSION}.jar"

export JAR_FILE

docker-compose up --build