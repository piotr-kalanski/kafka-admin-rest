FROM confluentinc/cp-kafka:4.0.0

CMD ["/usr/bin/java", "-jar", "/usr/share/service/service.jar"]

ADD target/lib           /usr/share/service/lib
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/service/service.jar