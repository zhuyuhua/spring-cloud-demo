#/bin/bash
echo "build fintech-app-business-version-control images"
docker rmi dev-fintech-hub.cgws.com/fintech-server/fintech-app-business-version-control:latest
docker build -t dev-fintech-hub.cgws.com/fintech-server/fintech-app-business-version-control:latest .
docker push dev-fintech-hub.cgws.com/fintech-server/fintech-app-business-version-control:latest