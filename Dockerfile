FROM tomcat:9.0.2-jre8-alpine
EXPOSE 8080
COPY target/product.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
