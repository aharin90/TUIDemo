<p><h3>GIT hub demo application</h3>

Here is github user info application that represents json of users repositories and its branches.


<p><h2>Run Application</h2>
User can run app in several ways:

As jar file:
Clone repository build jar with maven and run it with java -jar command

As Docker image:
Clone repository, cd to it and run
docker build -t tui .
docker run -p 8080:8080 tui

After application would be started it is recommended to visit Api doc for it by url:

http://localhost:8080/swagger-ui/

Here user would have a possibility to get more info about endpoint, request param and response body;