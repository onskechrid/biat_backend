fÚvr. 08, 2024 2:46:24 PM org.apache.catalina.core.StandardService startInternal
INFO: Starting service [Tomcat]
fÚvr. 08, 2024 2:46:24 PM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet engine: [Apache Tomcat/9.0.69]
fÚvr. 08, 2024 2:46:25 PM org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring embedded WebApplicationContext
fÚvr. 08, 2024 2:46:25 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: default]
fÚvr. 08, 2024 2:46:25 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.14.Final
fÚvr. 08, 2024 2:46:25 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
fÚvr. 08, 2024 2:46:26 PM org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator initiateService
WARN: HHH000342: Could not obtain connection to query metadata
java.sql.SQLException: ORA-00604: error occurred at recursive SQL level 1
ORA-01882: timezone region not found

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:630)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:559)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:554)
        at oracle.jdbc.driver.T4CTTIfun.processError(T4CTTIfun.java:1377)
        at oracle.jdbc.driver.T4CTTIoauthenticate.processError(T4CTTIoauthenticate.java:787)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:772)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:299)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTH(T4CTTIoauthenticate.java:455)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTHWithO5Logon(T4CTTIoauthenticate.java:1569)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTH(T4CTTIoauthenticate.java:1318)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTH(T4CTTIoauthenticate.java:1272)
        at oracle.jdbc.driver.T4CConnection.authenticateWithPassword(T4CConnection.java:1517)
        at oracle.jdbc.driver.T4CConnection.authenticateUserForLogon(T4CConnection.java:1466)
        at oracle.jdbc.driver.T4CConnection.logon(T4CConnection.java:679)
        at oracle.jdbc.driver.PhysicalConnection.connect(PhysicalConnection.java:1095)
        at oracle.jdbc.driver.T4CDriverExtension.getConnection(T4CDriverExtension.java:90)
        at oracle.jdbc.driver.OracleDriver.connect(OracleDriver.java:733)
        at oracle.jdbc.driver.OracleDriver.connect(OracleDriver.java:649)
        at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:138)
        at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:364)
        at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:206)
        at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:476)
        at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:561)
        at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:115)
        at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:68)
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:35)
        at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:101)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:237)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:214)
        at org.hibernate.id.factory.internal.DefaultIdentifierGeneratorFactory.injectServices(DefaultIdentifierGeneratorFactory.java:175)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.injectDependencies(AbstractServiceRegistryImpl.java:286)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:243)
        at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:214)
        at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:173)
        at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:127)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1460)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1494)
        at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1863)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:147)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:731)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:408)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:307)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292)
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:29)

fÚvr. 08, 2024 2:46:26 PM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.OracleDialect
fÚvr. 08, 2024 2:46:26 PM org.hibernate.dialect.Oracle9Dialect <init>
WARN: HHH000063: The Oracle9Dialect dialect has been deprecated; use either Oracle9iDialect or Oracle10gDialect instead
fÚvr. 08, 2024 2:46:26 PM org.hibernate.dialect.OracleDialect <init>
WARN: HHH000064: The OracleDialect dialect has been deprecated; use Oracle8iDialect instead
fÚvr. 08, 2024 2:46:28 PM org.hibernate.engine.jdbc.spi.SqlExceptionHelper logExceptions
WARN: SQL Error: 604, SQLState: 60000
fÚvr. 08, 2024 2:46:28 PM org.hibernate.engine.jdbc.spi.SqlExceptionHelper logExceptions
ERROR: ORA-00604: error occurred at recursive SQL level 1
ORA-01882: timezone region not found

fÚvr. 08, 2024 2:46:28 PM org.apache.catalina.core.StandardService stopInternal
INFO: Stopping service [Tomcat]
Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.exception.GenericJDBCException: Unable to open JDBC Connection for DDL execution
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1804)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:147)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:731)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:408)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:307)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292)
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:29)
Caused by: javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.exception.GenericJDBCException: Unable to open JDBC Connection for DDL execution
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:421)
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396)
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1863)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800)
        ... 16 more
Caused by: org.hibernate.exception.GenericJDBCException: Unable to open JDBC Connection for DDL execution
        at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:42)
        at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:113)
        at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:99)
        at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:71)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.jdbcStatement(GenerationTargetToDatabase.java:77)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:53)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlString(SchemaDropperImpl.java:387)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlStrings(SchemaDropperImpl.java:371)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:246)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:156)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:128)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:114)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:157)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
        at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58)
        at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365)
        at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409)
        ... 20 more
Caused by: java.sql.SQLException: ORA-00604: error occurred at recursive SQL level 1
ORA-01882: timezone region not found

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:630)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:559)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:554)
        at oracle.jdbc.driver.T4CTTIfun.processError(T4CTTIfun.java:1377)
        at oracle.jdbc.driver.T4CTTIoauthenticate.processError(T4CTTIoauthenticate.java:787)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:772)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:299)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTH(T4CTTIoauthenticate.java:455)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTHWithO5Logon(T4CTTIoauthenticate.java:1569)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTH(T4CTTIoauthenticate.java:1318)
        at oracle.jdbc.driver.T4CTTIoauthenticate.doOAUTH(T4CTTIoauthenticate.java:1272)
        at oracle.jdbc.driver.T4CConnection.authenticateWithPassword(T4CConnection.java:1517)
        at oracle.jdbc.driver.T4CConnection.authenticateUserForLogon(T4CConnection.java:1466)
        at oracle.jdbc.driver.T4CConnection.logon(T4CConnection.java:679)
        at oracle.jdbc.driver.PhysicalConnection.connect(PhysicalConnection.java:1095)
        at oracle.jdbc.driver.T4CDriverExtension.getConnection(T4CDriverExtension.java:90)
        at oracle.jdbc.driver.OracleDriver.connect(OracleDriver.java:733)
        at oracle.jdbc.driver.OracleDriver.connect(OracleDriver.java:649)
        at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:138)
        at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:364)
        at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:206)
        at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:476)
        at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:561)
        at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:115)
        at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112)
        at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122)
        at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181)
        at org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl.getIsolatedConnection(DdlTransactionIsolatorNonJtaImpl.java:44)
        ... 36 more






# Server configuration
server.port=8080
server.servlet.context-path=/api/v1

# DB Connection
spring.datasource.url=jdbc:oracle:thin:@172.28.70.46:1526:EXPL2
spring.datasource.username=rsq
spring.datasource.password=rsq2009

spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
#spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.database-platform=org.hibernate.dialect.Oracle10gDialect

spring.jpa.hibernate.ddl-auto=create

spring.jpa.properties.hibernate.jdbc.time_zone=CET

spring.jpa.hibernate.ejb.naming_strategy=org.hibernate.cfg.EJB3NamingStrategy
spring.jpa.hibernate.show_sql=true
spring.jpa.hibernate.format_sql=true
spring.jpa.hibernate.use_sql_comments=false
spring.jpa.hibernate.type=all
spring.jpa.hibernate.disableConnectionTracking=true
spring.jpa.hibernate.default_schema=dentalct
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
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





and this is an example of entity with annotations

package tn.biat.biat.entities.otherDB;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "RSQ")
public class ONS_History implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime actionTime;
    private String actionType;
    private String actionText;
}









 
