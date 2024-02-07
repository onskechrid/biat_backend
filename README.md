<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc11</artifactId>
			<version>21.11.0.0</version>
		</dependency>




  #Server configuration
server.port=8080
server.servlet.context-path=/api/v1

#--------------------- DB Connection ------------------
#spring.datasource.url=jdbc:postgresql://localhost:5432/biat
#spring.datasource.username=postgres
#spring.datasource.password=0000

spring.datasource.url=jdbc:oracle:thin:@172.28.70.46:1526:EXPL2
spring.datasource.username=rsq
spring.datasource.password=rsq2009

spring.datasource.driverClassName=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect 
spring.jpa.properties.hibernate.jdbc.time_zone=Africa/Tunis
#spring.datasource.driverClassName=org.postgresql.Driver
#spring.jpa.database-platform = org.hibernate.dialect.PostgreSQL94Dialect


spring.jpa.hibernate.hbm2ddl.auto=create
spring.jpa.hibernate.ddl-auto=create

spring.jpa.hibernate.ejb.naming_strategy=org.hibernate.cfg.EJB3NamingStrategy
spring.jpa.hibernate.show_sql=true
spring.jpa.hibernate.format_sql=true
spring.jpa.hibernate.use_sql_comments=false
spring.jpa.hibernate.type=all
spring.jpa.hibernate.disableConnectionTracking=true
spring.jpa.hibernate.default_schema=dentalct
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER


#spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL94Dialect
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
hibernate.globally_quoted_identifiers=true

spring.servlet.multipart.max-file-size=100000000MB
spring.servlet.multipart.max-request-size=100000000MB

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=ons.kechrid@esprit.tn
spring.mail.password=xcnvpingbyqdzlom
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
