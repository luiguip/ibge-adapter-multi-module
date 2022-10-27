FROM amazoncorretto:17
COPY ibge-adapter-launcher/target/ibge-adapter-launcher-0.0.1.jar ibge-adapter-launcher-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ibge-adapter-launcher-0.0.1.jar"]