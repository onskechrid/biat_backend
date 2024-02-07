# Database connection properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:yourDatabaseName
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# Hibernate properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle11gDialect
spring.jpa.properties.hibernate.jdbc.time_zone=UTC
