FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /chudam.jar

ENTRYPOINT ["java", "-jar", "/chudam.jar"]