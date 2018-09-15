#!/bin/bash
pid=`ps -e | grep spring-cloud |grep -v grep | awk '{print $1}' | xargs`
echo "pid:" $pid

kill -9 $pid