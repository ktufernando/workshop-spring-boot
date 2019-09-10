FROM java:8

WORKDIR /app

ARG JAR_FILE
ADD target/${JAR_FILE}.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]