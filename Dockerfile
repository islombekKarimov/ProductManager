FROM tomcat:8.0-jre8-alpine
EXPOSE 8080
COPY web/target/product.war /usr/local/tomcat/webapps/
