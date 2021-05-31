FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY target/*SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/creditcard-0.0.1-SNAPSHOT.jar"]