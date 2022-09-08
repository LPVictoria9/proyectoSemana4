FROM openjdk:11-jre-slim
COPY "./target/credit-service-0.0.1-SNAPSHOT.jar" "credit-service.jar"
EXPOSE 8085
ENTRYPOINT ["java", "-jar","credit-service.jar"]