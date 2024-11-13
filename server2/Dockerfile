FROM bellsoft/liberica-openjdk-alpine:17
# or
# FROM openjdk:8-jdk-alpine
# FROM openjdk:11-jdk-alpine

# 애플리케이션의 모든 파일 복사
COPY . .

# Gradle Wrapper에 실행 권한 부여
RUN #chmod +x ./gradlew

RUN #./gradlew clean build
#CMD ["./gradlew", "clean", "build"]
# or Maven
# CMD ["./mvnw", "clean", "package"]

ARG JAR_FILE=build/libs/*.jar
# or Maven
# ARG JAR_FILE_PATH=target/*.jar

COPY ${JAR_FILE} app.jar
COPY /src/main/resources/application.properties /application.properties
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]