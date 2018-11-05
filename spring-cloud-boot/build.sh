#/bin/bash
git pull
mvn install
docker rmi dev-fintech-hub.cgws.com/k8s/spring-cloud-boot:latest
docker build -t dev-fintech-hub.cgws.com/k8s/spring-cloud-boot:latest .
docker push dev-fintech-hub.cgws.com/k8s/spring-cloud-boot:latest
