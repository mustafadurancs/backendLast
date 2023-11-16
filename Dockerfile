FROM maven:3.6.3-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11-jdk-slim-sid
COPY --from=build /target/srs-sport-0.0.1-SNAPSHOT.jar srs-sport.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","srs-sport.jar"]
