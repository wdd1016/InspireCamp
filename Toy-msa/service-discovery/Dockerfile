FROM amazoncorretto:17
VOLUME /tmp
COPY build/libs/service-discovery-1.0.jar service-discovery.jar
ENTRYPOINT ["java", "-jar", "service-discovery.jar"]