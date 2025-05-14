FROM openjdk:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
WORKDIR /target
COPY ${JAR_FILE} ads-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/target/ads-0.0.1-SNAPSHOT.jar"]