FROM openjdk:11-jre-slim
COPY "./target/gateway-service-0.0.1-SNAPSHOT.jar" "gateway-service.jar"
EXPOSE 8090
ENTRYPOINT ["java", "-jar","gateway-service.jar"]