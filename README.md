Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.service.spi.ServiceException: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment]
Caused by: org.hibernate.service.spi.ServiceException: Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment]
Caused by: org.hibernate.boot.registry.selector.spi.StrategySelectionException: Unable to resolve name [org.hibernate.dialect.Oracle11gDialect] as strategy [org.hibernate.dialect.Dialect]
Caused by: org.hibernate.boot.registry.classloading.spi.ClassLoadingException: Unable to load class [org.hibernate.dialect.Oracle11gDialect]
Caused by: java.lang.ClassNotFoundException: Could not load requested class : org.hibernate.dialect.Oracle11gDialect



# Server configuration
server.port=8080
server.servlet.context-path=/api/v1

# DB Connection
spring.datasource.url=jdbc:oracle:thin:@172.28.70.46:1526:EXPL2
spring.datasource.username=rsq
spring.datasource.password=rsq2009

spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.Oracle11gDialect


spring.jpa.hibernate.hbm2ddl-auto=update
spring.jpa.hibernate.ddl-auto=update

#spring.jpa.properties.hibernate.jdbc.time_zone=Europe/Paris

spring.jpa.hibernate.ejb.naming_strategy=org.hibernate.cfg.EJB3NamingStrategy
spring.jpa.hibernate.show_sql=true
spring.jpa.hibernate.format_sql=true
spring.jpa.hibernate.use_sql_comments=false
spring.jpa.hibernate.type=all
spring.jpa.hibernate.disableConnectionTracking=true
spring.jpa.hibernate.default_schema=dentalct
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle11gDialect
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
hibernate.globally_quoted_identifiers = true

# Multipart settings
spring.servlet.multipart.max-file-size=100000000MB
spring.servlet.multipart.max-request-size=100000000MB

# Email settings
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=ons.kechrid@esprit.tn
spring.mail.password=xcnvpingbyqdzlom
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true



