FROM amazoncorretto:17
VOLUME /tmp
COPY apiEncryptionKey.jks apiEncryptionKey.jks
COPY build/libs/config-service-1.0.jar ConfServer.jar
ENTRYPOINT ["java","-jar","ConfServer.jar"]