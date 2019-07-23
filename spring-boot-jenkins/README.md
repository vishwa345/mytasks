# Kanp

#### Build using `dev Environment`

    mvn clean package -P dev

#### Build using `uat Environment`

    mvn clean package -P uat

#### Build using `Prod Environment`

    mvn clean package -P prod


#### Run this project using

    java -jar target/spring-boot-jenkins-pipeline-0.0.1-SNAPSHOT.jar

## Docker `Containerized Application`

### Publish the image `Locally`

    mvn install dockerfile:build
    
### Execute Container
    
    docker run -p 8091:8091 -t springio/spring-boot-jenkins-pipeline
    
    