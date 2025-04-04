<h3>OAuth Authentication Example API Testing Project written using REST Assured and POM Design Pattern</h3>  

A straightforward Example Demonstrating how to Obtain an Authentication Token and use it to make a Request to the API.

### Instructions to Execute the Test Suite
  
1) Clone the Repository  
2) Open the Project in an IDE  
3) Update the Maven Project  
4) Install TestNG (if not already installed)  
5) Execute the Test Suite via the Command Line Terminal:  
```
mvn -Dlog4j.configurationFile=src\test\resources\loggerconfig\log4j2.xml -Dsurefire.suiteXmlFiles=src\test\resources\suites\OauthTestSuite.xml test
```
### Test Log and Test Report  
  
* After each run, Test Log is stored in a timestamped .log file within the 'test_logs' directory,  
  while the Test Report is stored in a timestamped directory within the 'test_reports' directory.  
* Each report includes an 'html' directory where the simple, colour-coded view of the test results is stored.
  
### API Documentation  

```
Authorization Server EndPoint:

https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token


HTTP Method : POST

Form parameters :

client_id: 692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com

client_secret: erZOWM9g3UtwNRj340YYaK_W

grant_type: client_credentials

scope: trust

-------------------------------------

GetCourseDetails EndPoint (Secured by OAuth) :

https://rahulshettyacademy.com/oauthapi/getCourseDetails

HTTP Method : GET

Query Parameter : access_token
```
