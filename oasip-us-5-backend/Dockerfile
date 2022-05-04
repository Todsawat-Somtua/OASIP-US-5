FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/oasip-us-5-backend.jar /oasip-us-5-backend.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]