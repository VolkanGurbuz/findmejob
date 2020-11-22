FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} findmejob.jar
ENTRYPOINT ["java","-jar","/findmejob.jar"]