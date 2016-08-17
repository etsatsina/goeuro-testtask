# goeuro-testtask

## Technology Stack
* Spring Boot
* Java 8
* Maven
* Integration tests were implemented with the help of Junit and Spring Test Tools
* A HashMap was used as data structure for storing station ids and its directly connected stations

***

### How to run
```
mvn clean package
java -jar target/bus-route-0.0.1-SNAPSHOT.jar
```
or
```
mvn spring-boot:run
```
Can be runned without test file input, included default route example from the task into file  ```resources/template/route1```
If it has some problems with docker run, the content of the file can be replaced with other data and service can be runned as written before.

### Docker run
I added build.sh and service.sh files to the repo using provided template. I installed Docker ToolBox on Windows 10 and followed the steps which descrribed in the task. The image was successfully installed but then I guess something went wrong with service.sh script. Because when I type command ```docker logs dev-test``` it prints ```block command not found 39 row```. I see that the process kind of running by command ```docker ps``` however there is no logs creating at tmp folder but it should be if the service started. So curl command return that it cannot connect to the URL. I also played with host and port but still no results. I think that in native Docker it maybe will work.

### Other thoughts
I implemented the approach which transfer stations list from the route to station and connected stations. It will be more quick read for the user once it transformed and written to the dattasource. Also Mongodb can be used for storing this kind of key-value data. It will work while it is not required to show user additional info like which route number contains direct way between stations and so on.
