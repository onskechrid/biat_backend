<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.6</version>
    </parent>
    <groupId>tn.biat</groupId>
    <artifactId>biat</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>biat</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>15</java.version>
    </properties>
    <dependencies>
        <!-- Your existing dependencies -->
        <!-- Exclude slf4j-nop and slf4j-jdk14 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-nop</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-jdk14</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!-- Add Logback dependency -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
        </dependency>
        <!-- Your existing dependencies -->
    </dependencies>
    <!-- Your existing build configuration -->
</project>
