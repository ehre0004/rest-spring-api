FROM openjdk:17-jdk-slim
COPY build/libs/rest-spring-api-0.0.1-SNAPSHOT.jar student-service-0.0.1.jar
ENV PORT=8888
ENTRYPOINT [ "java", "-jar", "student-service-0.0.1.jar" ]