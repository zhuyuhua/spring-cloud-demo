#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "删除service-hello"
pid=`ps -e | grep spring-cloud-service-hello | grep -v grep |awk '{print $1}' | xargs`

kill -9 $pid

echo "启动service-hello"
cd $pwd/spring-cloud-service-hello/target

nohup java -jar spring-cloud-service-hello-0.0.1-SNAPSHOT.jar --server.port=8081 > $pwd/logs/hello-service-8081.log>&1 &
nohup java -jar spring-cloud-service-hello-0.0.1-SNAPSHOT.jar --server.port=8082 > $pwd/logs/hello-service-8082.log>&1 &




