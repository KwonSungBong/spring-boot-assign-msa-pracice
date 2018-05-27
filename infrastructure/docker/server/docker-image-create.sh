#!/bin/bash

cd ../../server/config-server
./gradlew clean build docker

cd ../eureka-service
./gradlew clean build docker

cd ../zuul-service
./gradlew clean build docker

exit 0