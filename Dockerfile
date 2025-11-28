FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew build --no-daemon
EXPOSE 8080
CMD ["java", "-jar", "build/libs/api-1.0.0.jar"]