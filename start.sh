#!/bin/bash

result=$(java -version 2>&1)

# java 17
if [[ $result == *"build 17"* ]]; then
  java -jar ./build/dummy-jdk17.jar 
# java 11
elif [[ $result == *"build 11"* ]]; then
  java -jar ./build/dummy-jdk11.jar 
else
  echo "cannot find java 11 or 17"
fi
