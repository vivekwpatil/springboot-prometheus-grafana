# Spring Boot 2 + Prometheus + Grafana with  docker-compose
[![Build Status](https://travis-ci.org/vivekwpatil/springboot-prometheus-grafana.svg?branch=master)](https://travis-ci.org/vivekwpatil/springboot-prometheus-grafana)

###How to build and run Application:

```
#First buid the project locally
mvn clean install

#Build Docker Image
docker build -f Dockerfile --build-arg port=8085 -t spring-boot .

#Run the Image
docker run -p 8085:8085 spring-boot
```
### Test your setup
Use curl to connect (on Windows the curl tool should be available in Git Bash shell)
```
$ curl http://192.168.99.100:8085/hello/5

```

You should see something like:
```
Hello Java Engineers
```
###How to run Application, Prometheus and Grafana using docker-compose:
```
docker-compose up
```
####Prometheus URL:
http://192.168.99.100:9090/targets
####Grafana URL:
http://192.168.99.100:3000 
#####-pre configured dashboard
http://192.168.99.100:3000/d/VU7ndCzWk/prometeus-local-stats?orgId=1&from=now-5m&to=now
#####I am using Docker Toolbox locally to run this application in windows.
Reference:
https://docs.docker.com/toolbox/toolbox_install_windows/


