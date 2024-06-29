FROM openjdk:17

WORKDIR app/

COPY . ./

RUN ./mvnw dependency:go-offline

ENTRYPOINT ["./mvnw", "spring-boot:run"]