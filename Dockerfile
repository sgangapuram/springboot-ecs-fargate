FROM docker.deere.com/maven:3.8.3-amazoncorretto-8
COPY target/spring-boot-ecs-Fargate-0.0.1-SNAPSHOT.jar spring-boot-ecs-Fargate-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-ecs-Fargate-0.0.1-SNAPSHOT.jar"]