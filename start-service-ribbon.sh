#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "启动service-ribbon"
cd $pwd/spring-cloud-service-ribbon/target
nohup java -jar spring-cloud-service-ribbon-0.0.1-SNAPSHOT.jar --server.port=9000 >> $pwd/logs/service-ribbon.log>&1 &
