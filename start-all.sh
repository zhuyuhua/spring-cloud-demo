#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "启动hello-service"
cd $pwd/spring-cloud-service-hello/target

nohup java -jar spring-cloud-service-hello-0.0.1-SNAPSHOT.jar --server.port=8081 > $pwd/logs/hello-service-8081.log>&1 &
nohup java -jar spring-cloud-service-hello-0.0.1-SNAPSHOT.jar --server.port=8082 > $pwd/logs/hello-service-8082.log>&1 &

echo "being to start ribbon"
cd $pwd/spring-cloud-service-ribbon/target
nohup java -jar spring-cloud-service-ribbon-0.0.1-SNAPSHOT.jar > $pwd/logs/ribbon-consumer.log>&1 &

echo "being to start feign"
cd $pwd/spring-cloud-service-feign/target
nohup java -jar spring-cloud-service-feign-0.0.1-SNAPSHOT.jar > $pwd/logs/feign-consumer.log>&1 &



