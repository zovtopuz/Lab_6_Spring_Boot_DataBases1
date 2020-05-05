
FROM openjdk:11

COPY  target/Lab-6-SpringBoot-1.0-SNAPSHOT.jar spring-app.jar
CMD ["java","-jar","spring-app.jar"]
