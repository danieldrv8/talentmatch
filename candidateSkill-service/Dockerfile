# Etapa 1: Construcción
FROM maven:3.8.8-eclipse-temurin-17 as builder

WORKDIR /app

# Copiar el POM padre y los módulos al contexto del contenedor
COPY ./pom.xml ./pom.xml
COPY ./candidate-skill-service ./candidate-skill-service

# Ir al directorio del módulo e instalar dependencias
WORKDIR /app/candidate-skill-service
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B

# Construir el JAR del módulo
RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copiar el JAR compilado desde la etapa anterior
COPY --from=builder /app/candidate-skill-service/target/candidate-skill-service-1.0-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
