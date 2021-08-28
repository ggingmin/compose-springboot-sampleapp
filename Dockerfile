FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/springboot-sample-app-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} springboot-sample-app.jar

ENTRYPOINT ["java", "-jar", "/springboot-sample-app.jar"]
