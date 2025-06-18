FROM eclipse-temurin:17-jre AS builder
COPY build/libs/yte-demo-app-0.0.1-SNAPSHOT.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM eclipse-temurin:17-jre
RUN groupadd yte && useradd -g yte yte

COPY --from=builder dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder snapshot-dependencies/ ./
RUN true
COPY --from=builder company-dependencies/ ./
COPY --from=builder application/ ./

USER yte
CMD ["sh", "-c", "java $DEFAULT_MANAGED_OPTS $JAVA_OPTS org.springframework.boot.loader.JarLauncher"]
