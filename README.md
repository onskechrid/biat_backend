application.properties ou application.yml :
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe

SELECT * FROM Attachement a WHERE name = :name AND size = :size AND type = :type

