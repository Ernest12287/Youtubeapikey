FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
RUN chmod +x gradlew && ./gradlew build --no-daemon
CMD ["java", "-jar", "build/libs/*.jar"]