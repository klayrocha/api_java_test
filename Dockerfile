FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/JumiaPhone-0.0.1-SNAPSHOT.jar jumiaPhone.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/jumiaPhone.jar"]
