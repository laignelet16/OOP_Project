# OOP_Project
We are creating a Broadway show ticket roulette where you let the computer choose your ticket fate. We will be using Java and SQL. 


**Idea**: Broadway Show Roulette
Description:
In this OOP project, we'll design a Broadway show roulette application. Users, as customers, can select three out of five Broadway shows. After making their choices, they proceed to payment. Once paid, they click 'Buy Ticket' and the application randomly selects one of their chosen shows. Users will see their ticket and show and will have the option to resale their ticket.

**Conclusion**:
In summary, our Broadway show roulette application combines user choice, detailed show descriptions, and a secure payment process to provide an immersive and enjoyable experience for customers. By seamlessly integrating entertainment and technology, we aim to deliver a memorable journey through the world of Broadway shows.

________________________________________

Before running the code, download DBeaver, Maven and Docker if you do not have it already it on your computer. 

WINDOW USER:

Maven: 
1. To install Maven, run the following command in an admin PowerShell:
  choco install maven
2. Close the admin PowerShell after Maven is installed. Check whether the installation was successful by opening a new terminal and running the following command:
  mvn --version

Docker: 
1. Note that the Windows Subsystem for Linux 2 (WSL2) must be installed before installing Docker Desktop. Open a new admin PowerShell and run the following command:
  wsl --list --verbose
2. If the response resembles the following, WSL is installed on your device:
  NAME          STATE      VERSION
  Ubuntu-20.04  Stopped    2
3. If you need to install WSL, run the following command in an admin PowerShell:
  wsl --install
Reminder:
1. Restart  computer after the WSL installation is completed.
2. To install Docker Desktop, run the following command in an admin PowerShell:
  choco install docker-desktop
3. Close the existing admin PowerShell after Docker Desktop is installed. Open a new admin PowerShell and run the following command in PowerShell:
  docker --version
4. The response should show the current version of docker; if it is then the installation is successful.
5. Open Docker Desktop to start the Docker Engine.

MySQL Docker Images:
1. Open PowerShell.
2. Pull the MySQL Docker image using the command: docker pull mysql:latest.
3. Copy the command and run the command:
docker run -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 --name mysql_local mysql:latest
4. Check in Docker Desktop that you have a new container
5. Manually start the container in Docker Desktop by pressing the "Run" button under the "Actions" column.

DBeaver:
1. Open a new admin PowerShell and run the command: choco install dbeaver.
Reminder: 
2. Fix issues if any appear. 
3. Update DBeaver with the command: choco upgrade dbeaver

Connect MySQL to DBeaver:
1	Open the DBeaver desktop app.
2	Select the Database menu in the top menu bar, then click "New Database Connection."
3	Select MySQL and click Next.
4	Enter "root" as the username and "password" as the password.
5	Select the Driver Properties tab.
6	Find "allowPublicKeyRetrieval" and change the value to "true."
7	Select Test Connection.
8	When the test is successful, click Finish.


MAC USER: 

Maven:
1. Install Homebrew and thne install Maven with the command:
  brew install maven
2. Then check installation with :
  mvn -v

Docker: 
1. Navigate to the Docker Desktop website for Mac installation. 
2. Select the "Mac with Intel Chip" or the "Mac with Apple Chip" button, depending on your computer. The Docker.dmg file will then download.
IMPORTANT
1. First check the OS version to ensure that a compatible version will download.
2. Double-click the Docker.dmg file to start the installation process.
3. Open Docker Desktop. You should now see a new container called mysql_local.
4. Manually start the container in Docker Desktop by pressing the "Run" button under the "Actions" column.


MySQL Docker Images: 
1. Open Terminal.
2. Pull the MySQL Docker image by using:
  docker pull mysql:latest
3. Run the following command:
docker run -e MYSQL_ROOT_PASSWORD=password -p 3306:3306 --name mysql_local mysql:latest

DBeaver: 
1. Open Terminal
2. Run: brew install --cask dbeaver-community.
4. Fix issues if any appear. 

Connect MySQL to DBeaver: 
1. Open the DBeaver desktop app.
2. Select the Database menu in the top menu bar, then click New Database Connection.
3. Select MySQL and click Next.
4. Enter "root" as the username and "password" as the password.
5. Click on the Driver Properties tab.
6. Find "allowPublicKeyRetrieval" and change the value to "true."
7. Click Test Connection.
8. When the test is successful, click Finish.


