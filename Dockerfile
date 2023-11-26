FROM gradle:8.4.0-jdk17 AS builder

WORKDIR /usr/src/app

COPY build.gradle.kts .

COPY settings.gradle.kts .

COPY gradlew .

RUN gradle wrapper

COPY gradlew.bat .

COPY src src

COPY .env .

RUN export $(grep -v '^#' .env | xargs -d '\n')

RUN ./gradlew clean build

FROM openjdk:17-jdk-slim

WORKDIR /usr/src/app

COPY --from=builder /usr/src/app/build/libs/trendella-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "trendella-0.0.1-SNAPSHOT.jar"]
