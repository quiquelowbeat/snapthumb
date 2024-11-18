#!/bin/bash

mvn clean package 

ARTIFACT_ID=$(mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout)
VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

JAR_FILE="${ARTIFACT_ID}-${VERSION}.jar"

export JAR_FILE

docker-compose -f docker-compose.debug.yml up --build