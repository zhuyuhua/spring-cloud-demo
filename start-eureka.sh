#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "删除eureka-server"
pid=`ps -e | grep eureka-server | grep -v grep |awk '{print $1}' | xargs`

kill -9 $pid


echo "启动eureka-server"
cd $pwd/spring-cloud-eureka-server/target
nohup java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1 > $pwd/logs/eureka-server-peer1.log>&1 &
nohup java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2 > $pwd/logs/eureka-server-peer2.log>&1 &

