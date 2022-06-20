FROM openjdk:11

COPY config.yml /data/testCode/config.yml
COPY /target/testCode-1.0-SNAPSHOT.jar /data/testCode/testCode-1.0-SNAPSHOT.jar

WORKDIR /data/testCode

RUN java -version

CMD ["java","-jar","testCode-1.0-SNAPSHOT.jar","server","config.yml"]

EXPOSE 8080-8081