#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "删除service-ribbon"
pid=`ps -e | grep spring-cloud-service-ribbon | grep -v grep |awk '{print $1}' | xargs`
kill -9 $pid

echo "启动service-ribbon"
cd $pwd/spring-cloud-service-ribbon/target
nohup java -jar spring-cloud-service-ribbon-0.0.1-SNAPSHOT.jar > $pwd/logs/ribbon-consumer.log>&1 &

