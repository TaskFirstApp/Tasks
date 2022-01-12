FROM openjdk:8
ADD target/Tasks-0.0.1-SNAPSHOT.jar tasks.jar
EXPOSE 9094
ENTRYPOINT ["java", "-jar", "-Xms512m", "-Xmx4096m", "/tasks.jar"]
