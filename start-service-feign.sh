#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd


echo "启动service-feign"
cd $pwd/spring-cloud-service-feign/target
nohup java -jar spring-cloud-service-feign-0.0.1-SNAPSHOT.jar --server.port=9001 >> $pwd/logs/service-feign.log>&1 &


