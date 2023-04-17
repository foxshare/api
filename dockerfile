FROM gittools/gitversion as git
WORKDIR /home/
RUN git clone https://github.com/foxshare/api.git
RUN ls -a

FROM maven:3-eclipse-temurin-17 AS builder
WORKDIR /home/
COPY --from=git /home /home
RUN ls -a
RUN --mount=type=cache,target=/root/.m2 cd /home/api && mvn package


FROM azul/zulu-openjdk-alpine:17-jre-headless-latest as jdk
WORKDIR /home/
COPY --from=builder /home/api/target/*.jar /home/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080