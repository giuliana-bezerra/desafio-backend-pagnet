FROM eclipse-temurin:17.0.8.1_1-jdk-jammy
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]