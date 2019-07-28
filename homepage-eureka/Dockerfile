FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/homepage-eureka-1.0-SNAPSHOT.jar /hp.jar
ENTRYPOINT ["java","-jar","/hp.jar"]