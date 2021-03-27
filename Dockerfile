FROM tomcat:9.0.2-jre8-alpine
EXPOSE 8080
ADD target/product.jar product.jar
ENTRYPOINT ["java", "-jar", "product.jar", "--spring.config.location=conf/application.properties"]
