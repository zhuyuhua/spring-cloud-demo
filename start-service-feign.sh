#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "删除service-feign"
pid=`ps -e | grep spring-cloud-service-feign | grep -v grep |awk '{print $1}' | xargs`
kill -9 $pid

echo "启动service-feign"
cd $pwd/spring-cloud-service-feign/target
nohup java -jar spring-cloud-service-feign-0.0.1-SNAPSHOT.jar > $pwd/logs/feign-consumer.log>&1 &



