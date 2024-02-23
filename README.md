PS C:\Users\06159\OneDrive - Banque Internationale Arabe de Tunisie\Bureau\APP\biat_backend> java -Xms512m -Xmx2048m -jar target/biat-0.0.1-SNAPSHOT.jar
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/C:/Users/06159/OneDrive%20-%20Banque%20Internationale%20Arabe%20de%20Tunisie/Bureau/APP/biat_backend/target/biat-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/slf4j-nop-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Users/06159/OneDrive%20-%20Banque%20Internationale%20Arabe%20de%20Tunisie/Bureau/APP/biat_backend/target/biat-0.0.1-SNAPSHOT.jar!/BOOT-INF/lib/slf4j-jdk14-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.helpers.NOPLoggerFactory]

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.6)

fÚvr. 23, 2024 10:02:28 AM org.apache.catalina.core.StandardService startInternal
INFO: Starting service [Tomcat]
fÚvr. 23, 2024 10:02:28 AM org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet engine: [Apache Tomcat/9.0.69]
fÚvr. 23, 2024 10:02:28 AM org.apache.catalina.core.ApplicationContext log
INFO: Initializing Spring embedded WebApplicationContext
fÚvr. 23, 2024 10:02:28 AM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: default]
fÚvr. 23, 2024 10:02:28 AM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 5.6.14.Final
fÚvr. 23, 2024 10:02:28 AM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
fÚvr. 23, 2024 10:02:29 AM org.hibernate.dialect.Dialect <init>
INFO: HHH000400: Using dialect: org.hibernate.dialect.Oracle12cDialect
fÚvr. 23, 2024 10:02:30 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "drop table RSQ.ONS_ATTACHEMENT cascade constraints" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop table RSQ.ONS_ATTACHEMENT cascade constraints" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 942, Position : 15, SQL = drop table RSQ.ONS_ATTACHEMENT cascade constraints, Original SQL = drop table RSQ.ONS_ATTACHEMENT cascade constraints, Error Message = ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:30 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "drop table RSQ.ONS_ATTACHEMENTRECLAMATION cascade constraints" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop table RSQ.ONS_ATTACHEMENTRECLAMATION cascade constraints" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 942, Position : 15, SQL = drop table RSQ.ONS_ATTACHEMENTRECLAMATION cascade constraints, Original SQL = drop table RSQ.ONS_ATTACHEMENTRECLAMATION cascade constraints, Error Message = ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:30 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "drop table RSQ.ONS_MENU cascade constraints" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop table RSQ.ONS_MENU cascade constraints" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 942, Position : 15, SQL = drop table RSQ.ONS_MENU cascade constraints, Original SQL = drop table RSQ.ONS_MENU cascade constraints, Error Message = ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:30 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "drop sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "drop sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlString(SchemaDropperImpl.java:387)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.applySqlStrings(SchemaDropperImpl.java:371)
        at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:256)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00972: l'identificateur est trop long

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 972, Position : 18, SQL = drop sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ, Original SQL = drop sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ, Error Message = ORA-00972: l'identificateur est trop long   

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:30 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "create sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ start with 1 increment by  1" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "create sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ start with 1 increment by  1" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:458)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:442)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:299)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:169)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:138)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:124)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:168)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00972: l'identificateur est trop long

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 972, Position : 20, SQL = create sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ start with 1 increment by  1, Original SQL = create sequence RSQ.ONS_DWM_PD_PAYMENT_DUE_DETAILS_SEQ start with 1 increment by  1, Error Message = ORA-00972: l'identificateur est trop long

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:31 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "create table RSQ.ONS_ATTACHEMENT (ID number(19,0) not null, NAME varchar2(255 char), PATH varchar2(255 char), SIZE varchar2(255 char), TYPE varchar2(255 char), primary key (ID))" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "create table RSQ.ONS_ATTACHEMENT (ID number(19,0) not null, NAME varchar2(255 char), PATH varchar2(255 char), SIZE varchar2(255 char), TYPE varchar2(255 char), primary key (ID))" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:458)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:442)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:325)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:169)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:138)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:124)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:168)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00904:  : identificateur non valide

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 904, Position : 110, SQL = create table RSQ.ONS_ATTACHEMENT (ID number(19,0) not null, NAME varchar2(255 char), PATH varchar2(255 char), SIZE varchar2(255 char), TYPE varchar2(255 char), primary key (ID)), Original SQL = create table RSQ.ONS_ATTACHEMENT (ID number(19,0) not null, NAME varchar2(255 char), PATH varchar2(255 char), SIZE varchar2(255 char), TYPE varchar2(255 char), primary key (ID)), Error Message = ORA-00904:  : identificateur non valide

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:31 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "create table RSQ.ONS_ATTACHEMENTRECLAMATION (ID number(19,0) not null, NC varchar2(255 char), Ref varchar2(255 char), SF varchar2(255 char), dateOperation varchar2(255 char), dateValeur varchar2(255 char), libelleOperation varchar2(255 char), montant varchar2(255 char), name varchar2(255 char), path varchar2(255 char), size varchar2(255 char), type varchar2(255 char), primary key (ID))" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "create table RSQ.ONS_ATTACHEMENTRECLAMATION (ID number(19,0) not null, NC varchar2(255 char), Ref varchar2(255 char), SF varchar2(255 char), dateOperation varchar2(255 char), dateValeur varchar2(255 char), libelleOperation varchar2(255 char), montant varchar2(255 char), name varchar2(255 char), path varchar2(255 char), size varchar2(255 char), type varchar2(255 char), primary key (ID))" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:458)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:442)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:325)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:169)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:138)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:124)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:168)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00904:  : identificateur non valide

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 904, Position : 321, SQL = create table RSQ.ONS_ATTACHEMENTRECLAMATION (ID number(19,0) not null, NC varchar2(255 char), Ref varchar2(255 char), SF varchar2(255 char), dateOperation varchar2(255 char), dateValeur varchar2(255 char), libelleOperation varchar2(255 char), montant varchar2(255 char), name varchar2(255 char), path varchar2(255 char), size varchar2(255 char), type varchar2(255 char), primary key (ID)), Original SQL = create table RSQ.ONS_ATTACHEMENTRECLAMATION (ID number(19,0) not null, NC varchar2(255 char), Ref varchar2(255 char), SF varchar2(255 char), dateOperation varchar2(255 char), dateValeur varchar2(255 char), libelleOperation varchar2(255 char), montant varchar2(255 char), name varchar2(255 char), path varchar2(255 char), size varchar2(255 char), type varchar2(255 char), primary key (ID)), Error Message = ORA-00904:  : identificateur non valide

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:31 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "create table RSQ.ONS_MENU (ID number(19,0) not null, active number(1,0) not null, checked number(1,0) not null, iconcomponent varchar2(255 char), idparent number(19,0), level number(10,0) not null, name varchar2(255 char), url varchar2(255 char), primary key (ID))" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "create table RSQ.ONS_MENU (ID number(19,0) not null, active number(1,0) not null, checked number(1,0) not null, iconcomponent varchar2(255 char), idparent number(19,0), level number(10,0) not null, name varchar2(255 char), url varchar2(255 char), primary key (ID))" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:458)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:442)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:325)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:169)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:138)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:124)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:168)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00904:  : identificateur non valide

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 904, Position : 169, SQL = create table RSQ.ONS_MENU (ID number(19,0) not null, active number(1,0) not null, checked number(1,0) not null, iconcomponent varchar2(255 char), idparent number(19,0), level number(10,0) not null, name varchar2(255 char), url varchar2(255 char), primary key (ID)), Original SQL = create table RSQ.ONS_MENU (ID number(19,0) not null, active number(1,0) not null, checked number(1,0) not null, iconcomponent varchar2(255 char), idparent number(19,0), level number(10,0) not null, name varchar2(255 char), url varchar2(255 char), primary key (ID)), Error Message = ORA-00904:  : identificateur non valide

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:31 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "alter table ONS_MENU_composants add constraint UK_7pgb4l6j7fhg1yp6ebjfua3yt unique (composants_ID)" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table ONS_MENU_composants add constraint UK_7pgb4l6j7fhg1yp6ebjfua3yt unique (composants_ID)" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:458)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:442)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:361)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:169)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:138)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:124)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:168)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-02264: nom dÚjÓ utilisÚ par une contrainte existante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 2264, Position : 47, SQL = alter table ONS_MENU_composants add constraint UK_7pgb4l6j7fhg1yp6ebjfua3yt unique (composants_ID), Original SQL = alter table ONS_MENU_composants add constraint UK_7pgb4l6j7fhg1yp6ebjfua3yt unique (composants_ID), Error Message = ORA-02264: nom dÚjÓ utilisÚ par une contrainte existante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:31 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "alter table ONS_MENU_composants add constraint FKo6yr07qaxx04vu3i0welytbcc foreign key (composants_ID) references RSQ.ONS_COMPOSANT" via JDBC 
Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table ONS_MENU_composants add constraint FKo6yr07qaxx04vu3i0welytbcc foreign key (composants_ID) references RSQ.ONS_COMPOSANT" via JDBC Statement
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:458)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:442)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:389)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:169)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:138)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:124)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:168)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-02264: nom dÚjÓ utilisÚ par une contrainte existante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 2264, Position : 47, SQL = alter table ONS_MENU_composants add constraint FKo6yr07qaxx04vu3i0welytbcc foreign key (composants_ID) references RSQ.ONS_COMPOSANT, Original SQL = alter table ONS_MENU_composants add constraint FKo6yr07qaxx04vu3i0welytbcc foreign key (composants_ID) references RSQ.ONS_COMPOSANT, Error Message = ORA-02264: nom dÚjÓ utilisÚ par une contrainte existante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:31 AM org.hibernate.tool.schema.internal.ExceptionHandlerLoggedImpl handleException
WARN: GenerationTarget encountered exception accepting command : Error executing DDL "alter table ONS_MENU_composants add constraint FKtc7bt9icr8368ql6vh9qwbehd foreign key (ONS_Menu_ID) references RSQ.ONS_MENU" via JDBC Statement
org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "alter table ONS_MENU_composants add constraint FKtc7bt9icr8368ql6vh9qwbehd foreign key (ONS_Menu_ID) references RSQ.ONS_MENU" via JDBC Statement     
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:67)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlString(SchemaCreatorImpl.java:458)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.applySqlStrings(SchemaCreatorImpl.java:442)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.createFromMetadata(SchemaCreatorImpl.java:389)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.performCreation(SchemaCreatorImpl.java:169)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:138)
        at org.hibernate.tool.schema.internal.SchemaCreatorImpl.doCreation(SchemaCreatorImpl.java:124)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:168)
        at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:85)
        at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:335)
        at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:471)
        at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1498)
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
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:702)
        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:608)
        at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:1335)
        at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:1041)
        at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:443)
        at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:533)
        at oracle.jdbc.driver.T4CStatement.doOall8(T4CStatement.java:176)
        at oracle.jdbc.driver.T4CStatement.executeForRows(T4CStatement.java:1305)
        at oracle.jdbc.driver.OracleStatement.executeSQLStatement(OracleStatement.java:1877)
        at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1520)
        at oracle.jdbc.driver.OracleStatement.executeInternal(OracleStatement.java:2557)
        at oracle.jdbc.driver.OracleStatement.execute(OracleStatement.java:2506)
        at oracle.jdbc.driver.OracleStatementWrapper.execute(OracleStatementWrapper.java:334)
        at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
        at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
        at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:54)
        ... 42 more
Caused by: Error : 942, Position : 116, SQL = alter table ONS_MENU_composants add constraint FKtc7bt9icr8368ql6vh9qwbehd foreign key (ONS_Menu_ID) references RSQ.ONS_MENU, Original SQL = alter table ONS_MENU_composants add constraint FKtc7bt9icr8368ql6vh9qwbehd foreign key (ONS_Menu_ID) references RSQ.ONS_MENU, Error Message = ORA-00942: Table ou vue inexistante

        at oracle.jdbc.driver.T4CTTIoer11.processError(T4CTTIoer11.java:710)
        ... 57 more

fÚvr. 23, 2024 10:02:31 AM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
fÚvr. 23, 2024 10:02:34 AM org.apache.catalina.core.StandardService stopInternal
INFO: Stopping service [Tomcat]
Exception in thread "main" java.lang.reflect.InvocationTargetException
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:108)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'pythonInterpreter' defined in tn.biat.biat.BiatApplication: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.python.util.PythonInterpreter]: Factory method 'pythonInterpreter' threw exception; nested exception is ImportError: Cannot import site module and its dependencies: No module named site
Determine if the following attributes are correct:
  * sys.path: [.\Lib, __classpath__, __pyclasspath__/]
    This attribute might be including the wrong directories, such as from CPython
  * sys.prefix: .
    This attribute is set by the system property python.home, although it can
    be often automatically determined by the location of the Jython jar file

You can use the -S option or python.import.site=false to not import the site module

        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:658)
        at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:486)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1352)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1195)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:955)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
        at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:147)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:731)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:408)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:307)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292)
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:32)
        ... 8 more
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.python.util.PythonInterpreter]: Factory method 'pythonInterpreter' threw exception; nested exception is ImportError: Cannot import site 
module and its dependencies: No module named site
Determine if the following attributes are correct:
  * sys.path: [.\Lib, __classpath__, __pyclasspath__/]
    This attribute might be including the wrong directories, such as from CPython
  * sys.prefix: .
    This attribute is set by the system property python.home, although it can
    be often automatically determined by the location of the Jython jar file

You can use the -S option or python.import.site=false to not import the site module

        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:185)
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:653)
        ... 27 more
Caused by: ImportError: Cannot import site module and its dependencies: No module named site
Determine if the following attributes are correct:
  * sys.path: [.\Lib, __classpath__, __pyclasspath__/]
    This attribute might be including the wrong directories, such as from CPython
  * sys.prefix: .
    This attribute is set by the system property python.home, although it can
    be often automatically determined by the location of the Jython jar file

You can use the -S option or python.import.site=false to not import the site module

        at org.python.core.Py.ImportError(Py.java:327)
        at org.python.core.Py.importSiteIfSelected(Py.java:1866)
        at org.python.util.PythonInterpreter.<init>(PythonInterpreter.java:111)
        at org.python.util.PythonInterpreter.<init>(PythonInterpreter.java:93)
        at org.python.util.PythonInterpreter.<init>(PythonInterpreter.java:70)
        at tn.biat.biat.BiatApplication.pythonInterpreter(BiatApplication.java:62)
        at tn.biat.biat.BiatApplication$$EnhancerBySpringCGLIB$$8034e25a$$FastClassBySpringCGLIB$$c901c029.invoke(<generated>)
        at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:244)
        at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331)
        at tn.biat.biat.BiatApplication$$EnhancerBySpringCGLIB$$8034e25a.pythonInterpreter(<generated>)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:64)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:154)
        ... 28 more
