FROM amazoncorretto:17
MAINTAINER Maximiliano_Pereira

COPY target/Maximiliano_Pereira-0.0.1-SNAPSHOT.jar Maximiliano_Pereira_app.jar

ENTRYPOINT ["java","-jar","/Maximiliano_Pereira_app.jar"]