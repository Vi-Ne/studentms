# Build Jar first using Maven in CI or local; for simplicity we do single-stage assuming jar produced
FROM eclipse-temurin:17-jre
WORKDIR /app
ARG JAR_FILE=target/studentms-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","/app/app.jar"]
