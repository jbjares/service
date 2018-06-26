FROM maven:3.5.4-jdk-8-alpine as build
LABEL maintainer="luk.zim91@gmail.com"
RUN mkdir -p /opt/build
COPY . /opt/build

WORKDIR /opt/build
RUN mvn clean verify

# ---------------------------------------------------------
FROM openjdk:8-alpine3.7
COPY --from=build /opt/build/target/pht-service-0.0.1-SNAPSHOT.jar  /opt/bin/app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/bin/app.jar"]
EXPOSE 8770
