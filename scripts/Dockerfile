FROM openjdk:11 AS builder
COPY . .
RUN ["./gradlew", "assemble", "--info"]

FROM openjdk:11-jre-slim-buster
RUN ["ls"]
RUN ["pwd"]
COPY --from=builder /build/libs/hello.jar .
CMD ["java", "-jar", "-Dspring.profiles.active=default", "hello.jar"]
