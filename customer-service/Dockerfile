FROM openjdk:11-jre-slim
COPY "./target/customer-service-0.0.1-SNAPSHOT.jar" "customer-service.jar"
EXPOSE 8087
ENTRYPOINT ["java", "-jar","customer-service.jar"]