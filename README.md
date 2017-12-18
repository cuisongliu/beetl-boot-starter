[![license](https://img.shields.io/badge/gradle-3.3-brightgreen.svg)](https://gradle.org)
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://opensource.org/licenses/mit-license.php)

#  [Beetl](https://github.com/javamonkey/beetl2.0)  integration  with beetl

Beetl-Spring-Boot-Starter 帮助你集成通用 [Beetl](https://github.com/javamonkey/beetl2.0) 到 Spring Boot。

Beetl-Spring-Boot-Starter will help you use [Beetl](https://github.com/javamonkey/beetl2.0) with Spring Boot.

## How to use

### maven

在pom.xml加入nexus资源库（解决中国访问慢的问题,已经加入中央仓库）

Add the following nexus repository(fix china access slow problem,already append to central nexus.)  to your pom.xml:

    <repositories>
        <repository>
            <id>nexus</id>
            <name>nexus</name>
            <url>http://maven.cuisongliu.com/content/groups/public</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

在pom.xml加入依赖

Add the following dependency to your pom.xml:
    
    <dependency>
       <groupId>com.ibeetl</groupId>
       <artifactId>beetl</artifactId>
       <version>2.7.24</version>
    </dependency>
    <dependency>
       <groupId>com.cuisongliu</groupId>
       <artifactId>beetl-spring-boot-starter</artifactId>
       <version>1.2</version>
     </dependency>

### gradle

在build.gradle加入nexus资源库（解决中国访问慢的问题,已经加入中央仓库）

Add the following nexus repository(fix china access slow problem,already append to central nexus.)  to your build.gradle:

    allprojects {
        repositories {
            mavenLocal()
            maven { url "http://maven.cuisongliu.com/content/groups/public" }
            mavenCentral()
            jcenter()
        }
    }
    
在build.gradle加入依赖

Add the following dependency to your build.gradle:
    
    compile "com.ibeetl:beetl:2+"
    compile "com.cuisongliu:beetl-spring-boot-starter:1+"
    
### springboot properties set

在application.properties 或者application.yml加入[相关参数]

at  application.properties or application.yml append some properties.

| properties | Defaults |
| :------|:------|
|spring.beetl.suffix|.btl|
|spring.beetl.content-type|text/html;charset=UTF-8|
|spring.beetl.root|classpath:/templates|
|spring.beetl.order|0|
|spring.beetl.function-root|classpath:/functions|
|spring.beetl.function-suffix|fn|
|spring.beetl.tag-root|classpath:/tags|
|spring.beetl.tag-suffix|tag|
|spring.beetl.placeholder-start|${|
|spring.beetl.placeholder-end|}|
|spring.beetl.statement-start|<%|
|spring.beetl.statement-end|%>|
|spring.beetl.auto-check|false|


## Example

    spring:
      beetl:
        suffix: .html
        auto-check: true

## Acknowledgments

 [Beetl](http://ibeetl.com/).