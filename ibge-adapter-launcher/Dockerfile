FROM amazoncorretto:17-alpine-jdk
COPY target/ibge-adapter-launcher-0.0.1-SNAPSHOT.jar ibge-adapter-launcher-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ibge-adapter-launcher-0.0.1-SNAPSHOT.jar"]