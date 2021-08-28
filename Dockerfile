FROM openjdk:8-jdk-alpine as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew
RUN ./gradlew bootjar

FROM openjdk:8-jdk-alpine

COPY --from=builder build/libs/*.jar springboot-sample-app.jar
VOLUME /tmp
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/springboot-sample-app.jar"]
