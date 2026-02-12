FROM openjdk:17
WORKDIR /app
COPY ./target/aws-ecs-example-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080

LABEL authors="hazar"

ENTRYPOINT ["java", "-jar","aws-ecs-example-0.0.1-SNAPSHOT.jar"]