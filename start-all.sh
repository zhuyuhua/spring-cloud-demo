#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "启动eureka-server"
cd $pwd/spring-cloud-eureka-server/target
nohup java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1 >> $pwd/logs/eureka-server-peer1-1111.log>&1 &
nohup java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2 >> $pwd/logs/eureka-server-peer2-1112.log>&1 &



echo "启动service-hello"
cd $pwd/spring-cloud-service-hello/target

nohup java -jar spring-cloud-service-hello-0.0.1-SNAPSHOT.jar --server.port=8081 >> $pwd/logs/service-hello-8081.log>&1 &
nohup java -jar spring-cloud-service-hello-0.0.1-SNAPSHOT.jar --server.port=8082 >> $pwd/logs/service-hello-8082.log>&1 &

echo "启动service-ribbon"
cd $pwd/spring-cloud-service-ribbon/target
nohup java -jar spring-cloud-service-ribbon-0.0.1-SNAPSHOT.jar --server.port=9000 >> $pwd/logs/service-ribbon.log>&1 &

echo "启动service-feign"
cd $pwd/spring-cloud-service-feign/target
nohup java -jar spring-cloud-service-feign-0.0.1-SNAPSHOT.jar --server.port=9001 >> $pwd/logs/service-feign.log>&1 &

echo "启动service-zuul"
cd $pwd/spring-cloud-service-zuul/target
nohup java -jar spring-cloud-service-zuul-0.0.1-SNAPSHOT.jar --server.port=8679>> $pwd/logs/service-zuul.log>&1 &



