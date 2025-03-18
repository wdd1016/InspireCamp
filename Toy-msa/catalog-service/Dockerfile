FROM amazoncorretto:17
VOLUME /tmp
COPY build/libs/catalog-service-1.0.jar catalog-service.jar
ENTRYPOINT ["java", "-jar", "catalog-service.jar"]