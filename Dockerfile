# Étape 1 : Compilation avec une image Maven officielle et stable
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app

# 1. Copier le pom.xml pour télécharger les dépendances (MapStruct, Spring, etc.)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 2. Copier le code source
COPY src src

# 3. Compiler le projet en créant le JAR (et générer les mappers MapStruct automatiquement)
RUN mvn clean package -DskipTests

# Étape 2 : Création de l'image d'exécution finale (légère)
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copier le fichier JAR généré à l'étape 1
COPY --from=build /app/target/*.jar app.jar

# Exposer le port réseau
EXPOSE 8080

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]