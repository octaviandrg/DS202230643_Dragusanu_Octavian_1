FROM openjdk:11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw clean
RUN ./mvnw dependency:resolve

COPY src ./src
RUN ./mvnw package

CMD ["./mvnw", "spring-boot:run"]