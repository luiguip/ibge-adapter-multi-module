FROM amazoncorretto:17-alpine-jdk
COPY ibge-adapter-launcher/target/ibge-adapter-launcher-0.0.1-SNAPSHOT.jar ibge-adapter-launcher-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/ibge-adapter-launcher-0.0.1-SNAPSHOT.jar"]