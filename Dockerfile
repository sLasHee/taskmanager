FROM bellsoft/liberica-openjdk-alpine:17 as builder
WORKDIR /taskmanager
COPY . .
RUN ./gradlew clean bootJar
FROM bellsoft/liberica-openjdk-alpine:17
ENV TZ="Europe/Moscow"
WORKDIR /taskmanager
COPY --from=builder /taskmanager/build/libs/*.jar /taskmanager/*.jar
ENTRYPOINT ["java", "-jar", "/taskmanager/*.jar"]
