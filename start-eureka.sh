#!/bin/bash
pwd=`pwd`
echo "当前目录:" $pwd

echo "启动eureka-server"

cd $pwd/spring-cloud-eureka-server/target
nohup java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1 >> $pwd/logs/eureka-server-peer1-1111.log>&1 &
nohup java -jar spring-cloud-eureka-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2 >> $pwd/logs/eureka-server-peer2-1112.log>&1 &

