[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------------< tn.biat:biat >----------------------------
[INFO] Building biat 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot:2.7.6:run (default-cli) > test-compile @ biat >>>
[WARNING] The artifact mysql:mysql-connector-java:jar:8.0.31 has been relocated to com.mysql:mysql-connector-j:jar:8.0.31: MySQL Connector/J artifacts moved to reverse-DNS compliant Maven 2+ coordinates.
[INFO] 
[INFO] --- resources:3.2.0:resources (default-resources) @ biat ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] Copying 1 resource
[INFO] Copying 1 resource
[INFO] 
[INFO] --- compiler:3.10.1:compile (default-compile) @ biat ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- resources:3.2.0:testResources (default-testResources) @ biat ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Using 'UTF-8' encoding to copy filtered properties files.
[INFO] skip non existing resourceDirectory C:\Users\06159\OneDrive - Banque Internationale Arabe de Tunisie\Bureau\APP\biat_backend\src\test\resources
[INFO]
[INFO] --- compiler:3.10.1:testCompile (default-testCompile) @ biat ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] <<< spring-boot:2.7.6:run (default-cli) < test-compile @ biat <<<
[INFO]
[INFO]
[INFO] --- spring-boot:2.7.6:run (default-cli) @ biat ---
[INFO] Attaching agents: []
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/C:/Users/06159/.m2/repository/org/slf4j/slf4j-nop/1.7.36/slf4j-nop-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Users/06159/.m2/repository/org/slf4j/slf4j-jdk14/1.7.36/slf4j-jdk14-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Users/06159/.m2/repository/ch/qos/logback/logback-classic/1.2.11/logback-classic-1.2.11.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.helpers.NOPLoggerFactory]
Exception in thread "main" java.lang.IllegalArgumentException: LoggerFactory is not a Logback LoggerContext but Logback is on the classpath. Either remove Logback or the competing implementation (class org.slf4j.helpers.NOPLoggerFactory loaded from file:/C:/Users/06159/.m2/repository/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar). If you are using WebLogic you will need to add 'org.slf4j' to prefer-application-packages in WEB-INF/weblogic.xml: 
org.slf4j.helpers.NOPLoggerFactory
        at org.springframework.util.Assert.instanceCheckFailed(Assert.java:702)
        at org.springframework.util.Assert.isInstanceOf(Assert.java:621)
        at org.springframework.boot.logging.logback.LogbackLoggingSystem.getLoggerContext(LogbackLoggingSystem.java:294)
        at org.springframework.boot.logging.logback.LogbackLoggingSystem.beforeInitialize(LogbackLoggingSystem.java:118)
        at org.springframework.boot.context.logging.LoggingApplicationListener.onApplicationStartingEvent(LoggingApplicationListener.java:238)
        at org.springframework.boot.context.logging.LoggingApplicationListener.onApplicationEvent(LoggingApplicationListener.java:220)
        at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:176)
        at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:169)
        at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:143)
        at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:131)
        at org.springframework.boot.context.event.EventPublishingRunListener.starting(EventPublishingRunListener.java:79)
        at org.springframework.boot.SpringApplicationRunListeners.lambda$starting$0(SpringApplicationRunListeners.java:56)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:120)
        at org.springframework.boot.SpringApplicationRunListeners.starting(SpringApplicationRunListeners.java:56)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:298)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292)
        at tn.biat.biat.BiatApplication.main(BiatApplication.java:30)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.026 s
[INFO] Finished at: 2024-02-07T10:59:39+01:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:2.7.6:run (default-cli) on project biat: Application finished with exit code: 1 -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
