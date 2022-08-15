#!/usr/bin/env bash

TAG="0.1.0"

docker build -f Dockerfile .. -t markruler/spring-hello-world
docker tag markruler/spring-hello-world markruler/spring-hello-world:${TAG}
docker push markruler/spring-hello-world:${TAG}
docker push markruler/spring-hello-world
# docker run -d --name app -p 8080:8080 markruler/spring-hello-world
