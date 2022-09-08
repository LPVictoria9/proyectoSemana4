FROM openjdk:11-jre-slim
COPY "./target/configServer-0.0.1-SNAPSHOT.jar" "config-service.jar"
EXPOSE 8888
ENTRYPOINT ["java", "-jar","config-service.jar"]