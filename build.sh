#!/bin/bash

./gradlew clean build
docker build -t aws-copilot-app-example:latest ./