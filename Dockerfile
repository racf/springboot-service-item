FROM openjdk:11
VOLUME /tmp
EXPOSE 8002
ADD ./target/springboot-servicio-item-0.0.1-SNAPSHOT.war service-items.war
ENTRYPOINT ["java", "-jar", "/service-items.war"]