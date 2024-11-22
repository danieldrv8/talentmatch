FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /app
COPY ./pom.xml ./pom.xml
COPY ./api-gateway/ ./api-gateway

WORKDIR /app/api-gateway
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/api-gateway/target/api-gateway-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
