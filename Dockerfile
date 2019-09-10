FROM openjdk:8
ADD target/docker-spring-boot.jar docker-spring-boot.jar
ARG port
EXPOSE $port
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
