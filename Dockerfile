# 스프링 부트 프로젝트 빌드 및 jar 파일 생성
FROM openjdk:8-jdk-alpine as builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootjar

# builder에서 jar 파일 복사 및 실행
FROM openjdk:8-jdk-alpine
COPY --from=builder build/libs/*.jar springboot-sample-app.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/springboot-sample-app.jar"]