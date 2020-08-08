FROM openjdk:jdk-alpine
VOLUME /tmp
RUN mkdir /aws-copilot-app-example
WORKDIR /aws-copilot-app-example

ENV JAVA_OPTS=""
ENV APP_VERSION=0.0.1-SNAPSHOT

COPY ./build/libs/aws-copilot-app-example-$APP_VERSION.jar /aws-copilot-app-example

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ./aws-copilot-app-example-$APP_VERSION.jar" ]