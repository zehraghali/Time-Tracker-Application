
FROM openjdk:21

WORKDIR /app

COPY target/SportsTimeTracker-1.0-SNAPSHOT.jar /app/SportsTimeTracker.jar

CMD ["java", "-jar", "SportsTimeTracker.jar"]
