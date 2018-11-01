FROM dev-fintech-hub.cgws.com/library/java:8
WORKDIR /app
ADD ./target/spring-cloud-boot-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app/app.jar"]
