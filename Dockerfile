FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /patientrapport.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/patientrapport.jar"]