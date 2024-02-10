FROM maven:3-openjdk-17 as build-image
WORKDIR /to-build-app
COPY . .
RUN mvn dependency:go-offline
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
COPY --from=build-image /to-build-app/target/*.jar /app/to-build-app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/to-build-app.jar"]