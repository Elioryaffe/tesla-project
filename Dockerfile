FROM eclipse-temurin:11-jre
COPY target/tesla-project*.jar /usr/src/tesla-project.jar
COPY src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/tesla-project.jar", "--spring.config.location=file:/opt/conf/application.properties"]