
FROM openjdk:17-oracle
ARG JAR_FILE=*.jar
COPY ./target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
