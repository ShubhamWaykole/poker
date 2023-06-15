FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/poker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} poker.jar
COPY src/main/resources/application.properties application.properties
ENTRYPOINT ["java","-jar","/poker.jar"]