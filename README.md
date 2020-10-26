## BBC View Comments Automation test scenarios

It is a Selenium-Java based frontend automation suite utilising the BDD methodologies of Cucumber and Gherkin
##### System Requirements
- JAVA
- Maven 
- All other required dependencies are in BBC_Test/pom.xml
  
  
##### Installation and Launch automation test scenarios for BBC_Test

- Step I : Download the zip or clone the Git repository
```
https://github.com/Satesh123/BBC_Test
```
- Step II : Unzip the zip file (if you downloaded one).
- Step III : Open Command Prompt and Change directory (cd) to folder BBC_Test.
- Step IV : Run command (Will run in CHROME as defult browser): 
```
mvn clean test
```
   If you want to run in a different browser then follow below command
```
mvn test -DBROWSER=FIREFOX -DHOST=LOCAL
mvn test -DBROWSER=EDGE -DHOST=LOCAL
mvn test -DBROWSER=IE -DHOST=LOCAL
```
- Step IV : Find test report 
```
HTML     : BBC_Test/target/cucumber-html-report/index.html
Cucumber : BBC_Test/target/cucumber-reports/report.html
JSON     : BBC_Test/target/cucumber-json-report.json
```
