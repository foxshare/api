#FROM iits/jdk17-docker:jdk-17-docker
FROM openjdk:8-jdk-alpine
ADD /target/api-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

