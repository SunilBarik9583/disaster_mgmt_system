FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8086

ENTRYPOINT ["java","-Xms128m","-Xmx256m","-jar","app.jar"]