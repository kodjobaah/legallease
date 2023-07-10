FROM --platform=linux/amd64  openjdk:17-alpine

COPY target/firmranking-0.0.1-SNAPSHOT.jar firmranking-0.0.1.jar
ENTRYPOINT ["java","-jar","/firmranking-0.0.1.jar"]