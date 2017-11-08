# 1	REST API with Java Spring and Mongo DB 
# 1.1	- Abstract 
 
Hello everyone. This year I had opportunity to work deeply with different technologies from Microsoft World. My first challenge happened during the dev environment setup where in my humble opinion, it is more detailed and manual process compared with applications developed using Visual Studio. The language is similar but you have to understand better how the components works and conventions are expected. Based on these challenges, I felt motivated to start writing about it in a funny way, starting by the name that is based on Tela Class Chapter: Aventuras do Ninja Loki (Portuguese Name).
In this article, I will show an interesting adventure of .Net developer to how to develop a RESTful web application by using spring and mongo DB without implementing boring uniform controllers. This application will call RockBand and it will expose information about bands from Rock Roll World. You can see all code related to this article:
1.2	- Introduction
When it comes to RESTful application, we need an API that mainly handles CRUD operations. Let me give you example to clarify what I mean by sentence above. Let say that, you have a REST endpoint /RockBands that allows you to perform RockBand related operations like RockBand Create, RockBand Update, RockBand View, RockBand Delete, or RockBand Search. 
The minimum code requirements for designing such an endpoint is nearly same for every resources like below:
Design your domain model (RockBand)
Implement Repository
Implement Controller
You will see the term resource in this article frequently. It is one of the main components of the RESTful design and you can refer here to learn more about what a resource is.
By using above components, you can handle requests with controllers, validate and convert request to Entity, and finally perform CRUD operation by using Service that use DAO classes for each entity. In this situation, you need to code 4 endpoint for each resource (RockBand is a resource here). Let say that you have 10 resources in your project like User, Comment, History, etc. You will have 10 x 4 endpoint needs to be implemented. 
Those endpoints are mainly same for all resources.  In addition, if we do not need to implement those CRUD endpoints for each resources? We will use Spring Data Rest project for lead to implement RESTful services by implementing only Repository and Domain Model.
 
 
# 1.3	- Requirements

In this project, we will need following requirements:
•	Maven 3.x
•	Spring Boot 1.2.5
•	Valid MongoDB database

1.3.1	- Download VS Code and Apache Maven and install both.
https://code.visualstudio.com/download
https://maven.apache.org/download.cgi

1.3.2	- Automating environment setup with chocolatey:
https://chocolatey.org/install (see more details)

Install chocolatey via cmd.exe: 
@"%SystemRoot%\System32\WindowsPowerShell\v1.0\powershell.exe" -NoProfile -InputFormat None -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" && SET "PATH=%PATH%;%ALLUSERSPROFILE%\chocolatey\bin"

Installing everything via chocolatey:
choco install visualstudiocode
choco install maven
choco install mongodb
choco install robo3t.install (robomongo IDE)

# 2 - Install the Visual Studio extension pack for Java:
 

# 3 - If necessary, the Maven quick start archetype could be used to generate a new Maven project in an appropriate local folder: 
mvn archetype:generate -DgroupId=com.companyname.appname-DartifactId=appname-DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false. 
This will create an appname folder with Maven's Standard Directory Layout (i.e. src/main/java/com/companyname/appname and src/main/test/com/companyname/appname to begin with and a sample "Hello World!" Java file named appname.java and associate unit test named appnameTest.java).
4 - Open the Maven project folder in VS Code via File menu -> Open Folder... select the appname folder.
5 - Open the Command Palette (via the View menu or by right clicking) and type in and select Tasks: Configure task then select Create tasks.json from template.
6 - Choose maven ("Executes common Maven commands"). This creates a tasks.json file with "verify" and "test" tasks. More can be added corresponding to other Maven Build Lifecycle phases. To specifically address your requirement for classes to be built without a JAR file, a "compile" task would need to be added as follows:
{
    "taskName": "compile",
    "type": "shell",
    "command": "mvn -B compile",
    "group": "build"
},

7 - Save the above changes and then open the Command Palette and select "Tasks: Run Build Task" then pick "compile" and then "Continue without scanning the task output". This invokes Maven, which creates a target folder at the same level as the src folder with the compiled class files in the target\classes folder.
UPDATE (placeholder): How to run/debug a class
1.4	- How to debug Java into VSCode?

1 - Show the Debug view (via View menu >> Debug or Ctrl + Shift + D).
2 - Click on the green arrow in the Debug view and select "Java".
3 - Assuming it has not already been created, a message "launch.json is needed to start the debugger. Do you want to create it now?" will appear - select "Yes" and then select "Java" again.
4 - Enter the fully qualified name of the main class (e.g. com.company-name.application-name.App) in the value for "mainClass" and save the file.
5 - Click on the green arrow in the Debug view again.

