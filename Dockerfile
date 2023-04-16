
FROM openjdk:8-jdk
ARG JAR_FILE=*.jar
COPY ./target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]