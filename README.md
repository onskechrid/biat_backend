[INFO] Scanning for projects...
Downloading from central: https://repo.maven.apache.org/maven2/org/springframework/boot/spring-boot-starter-parent/2.7.6/spring-boot-starter-parent-2.7.6.pom
[ERROR] [ERROR] Some problems were encountered while processing the POMs:
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: mysql:mysql-connector-java:jar -> duplicate declaration of version (?) @ line 65, column 15  
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: com.fasterxml.jackson.core:jackson-databind:jar -> version (?) vs 2.10.0 @ line 99, column 15[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework.boot:spring-boot-starter-test:jar -> duplicate declaration of version (?) @ line 110, column 15
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework.boot:spring-boot-starter-data-rest:jar -> duplicate declaration of version (?) @ line 120, column 15
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework.boot:spring-boot-starter-security:jar -> duplicate declaration of version (?) @ line 124, column 15
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework.boot:spring-boot-starter-test:jar -> duplicate declaration of version (?) @ line 128, column 15
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework.security:spring-security-test:jar -> duplicate declaration of version (?) @ line 133, column 15
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework.boot:spring-boot-starter-security:jar -> duplicate declaration of version (?) @ line 152, column 15
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: com.auth0:java-jwt:jar -> duplicate declaration of version 3.19.2 @ line 156, column 21      
[WARNING] 'build.plugins.plugin.(groupId:artifactId)' must be unique but found duplicate declaration of plugin org.springframework.boot:spring-boot-maven-plugin @ line 234, column 12[FATAL] Non-resolvable parent POM for tn.biat:biat:0.0.1-SNAPSHOT: The following artifacts could not be resolved: org.springframework.boot:spring-boot-starter-parent:pom:2.7.6 (absent): Could not transfer artifact org.springframework.boot:spring-boot-starter-parent:pom:2.7.6 from/to central (https://repo.maven.apache.org/maven2): Connection reset and 'parent.relativePath' points at no local POM @ line 5, column 10
 @
[ERROR] The build could not read 1 project -> [Help 1]
[ERROR]
[ERROR]   The project tn.biat:biat:0.0.1-SNAPSHOT (C:\Users\06159\OneDrive - Banque Internationale Arabe de Tunisie\Bureau\APP\biat_backend\pom.xml) has 1 error
[ERROR]     Non-resolvable parent POM for tn.biat:biat:0.0.1-SNAPSHOT: The following artifacts could not be resolved: org.springframework.boot:spring-boot-starter-parent:pom:2.7.6 (absent): Could not transfer artifact org.springframework.boot:spring-boot-starter-parent:pom:2.7.6 from/to central (https://repo.maven.apache.org/maven2): Connection reset and 'parent.relativePath' points at no local POM @ line 5, column 10 -> [Help 2]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/ProjectBuildingException
[ERROR] [Help 2] http://cwiki.apache.org/confluence/display/MAVEN/UnresolvableModelException
