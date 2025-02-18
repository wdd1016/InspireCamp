FROM        openjdk:21 AS build
ARG         JAR_FILE=build/libs/*.jar
COPY        ${JAR_FILE} /app.jar
#ENTRYPOINT  ["java", "-jar", "/app.jar"]
RUN         mkdir -p /target/dependency && (cd /target/dependency; jar -xf /app.jar)

FROM        openjdk:21
ARG         DEPENDENCY=/target/dependency
COPY        --from=build ${DEPENDENCY}/BOOT-INF/lib      /app/lib
COPY        --from=build ${DEPENDENCY}/META-INF          /app/META-INF
COPY        --from=build ${DEPENDENCY}/BOOT-INF/classes  /app
ENTRYPOINT  ["java", "-cp", "/app:/app/lib/*", "com.optimagrowth.license.LicenseServiceApplication"]
