FROM openjdk:8
ADD target/scanlib-0.0.1-SNAPSHOT.jar  scanlib-0.0.1-SNAPSHOT.jar
EXPOSE 9595
ENTRYPOINT ["java", "-jar", "scanlib-0.0.1-SNAPSHOT.jar"]

