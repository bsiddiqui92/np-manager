FROM mysql:8.0.2


COPY mysql/*.sh /tmp/scripts/
ENTRYPOINT["/tmp/scripts/init-db.sh"]
CMD["/etc/init.d/mysql start"]

#COPY ./mysql-data/npmanager-structure.sql /usr/sql/npmanager-structure.sql

#FROM tomcat:9.0.13
#ADD ./target/npmanager.war /usr/local/tomcat/webapps/
#CMD chmod +x /usr/local/tomcat/bin/catalina.sh
#CMD ["catalina.sh", "run"]


