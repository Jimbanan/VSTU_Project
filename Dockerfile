#./mvnw package && java -jar target/VSTU_Project-0.0.1-SNAPSHOT.jar

FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8190
ARG JAR_FILE=target/VSTU_Project-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]

#docker build -t application:0.0.1 .