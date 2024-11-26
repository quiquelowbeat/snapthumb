#!/bin/bash

mvn test -f backend/pom.xml

ARTIFACT_ID=$(mvn help:evaluate -f backend/pom.xml -Dexpression=project.artifactId -q -DforceStdout)
VERSION=$(mvn help:evaluate -f backend/pom.xml -Dexpression=project.version -q -DforceStdout)

JAR_FILE="${ARTIFACT_ID}-${VERSION}.jar"

export JAR_FILE

docker-compose -f docker-compose.backend.debug.yml up --build