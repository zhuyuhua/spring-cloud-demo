#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "启动service-zuul"
cd $pwd/spring-cloud-service-zuul/target
nohup java -jar spring-cloud-service-zuul-0.0.1-SNAPSHOT.jar --server.port=8679>> $pwd/logs/service-zuul.log>&1 &
