FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} resume-sender-service.jar
ENTRYPOINT ["java","-jar","/resume-sender-service.jar"]
