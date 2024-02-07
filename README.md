SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/C:/Users/06159/.m2/repository/org/slf4j/slf4j-nop/1.7.36/slf4j-nop-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Users/06159/.m2/repository/org/slf4j/slf4j-jdk14/1.7.36/slf4j-jdk14-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Users/06159/.m2/repository/ch/qos/logback/logback-classic/1.2.11/logback-classic-1.2.11.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.helpers.NOPLoggerFactory]
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.221 s <<< FAILURE! - in tn.biat.biat.BiatApplicationTests
[ERROR] contextLoads  Time elapsed: 0.004 s  <<< ERROR!
java.lang.IllegalStateException: Failed to load ApplicationContext
Caused by: java.lang.IllegalArgumentException: LoggerFactory is not a Logback LoggerContext but Logback is on the classpath. Either remove Logback or the competing implementation (class org.slf4j.helpers.NOPLoggerFactory loaded from file:/C:/Users/06159/.m2/repository/org/slf4j/slf4j-api/1.7.36/slf4j-api-1.7.36.jar). If you are using WebLogic you will need to add 'org.slf4j' to prefer-application-packages in WEB-INF/weblogic.xml: org.slf4j.helpers.NOPLoggerFactory
