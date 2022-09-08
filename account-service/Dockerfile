FROM openjdk:11-jre-slim
COPY "./target/account-service-0.0.1-SNAPSHOT.jar" "account-service.jar"
EXPOSE 8088
ENTRYPOINT ["java", "-jar","account-service.jar"]