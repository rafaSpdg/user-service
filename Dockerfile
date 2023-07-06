FROM maven:3.9.2-eclipse-temurin AS builder

WORKDIR /home/maven

ADD pom.xml .

RUN mvn dependency:resolve

ADD src src

RUN mvn clean install

FROM eclipse-temurin AS release

WORKDIR /opt/user-service

COPY --from=builder /home/maven/target/user-service-0.0.1-SNAPSHOT.jar user-service.jar

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar user-service.jar ${0} ${@}"]
