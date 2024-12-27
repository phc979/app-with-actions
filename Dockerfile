FROM openjdk:17-jdk-slim

# JAR 파일 이름 설정
ARG JAR_FILE=target/app.jar
COPY ${JAR_FILE} app.jar

# JVM 최적화 옵션 추가
ENTRYPOINT ["java", "-jar", "/app.jar"]
