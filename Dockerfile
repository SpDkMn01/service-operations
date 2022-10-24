FROM openjdk:11
VOLUME /tmp
EXPOSE 8000
ADD ./target/Operations-0.0.1-SNAPSHOT.jar Operations.jar
ENTRYPOINT ["java","-jar","/Operations.jar"]