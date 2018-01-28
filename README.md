# Sleeping-Sloth

#Database
Host: aali59sginzk8e.c9jeiy9iz9eo.us-east-2.rds.amazonaws.com
Username: sleepingsloth
Password: sleepingsloth1234theo
type: MySQL

#Application server Host
http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com


## Android/iOS application
Requirements: Ionic/Cordova

The App folder contains the information for the mobile applications. 
In order to build the files please use a command line to go in the folder and run the following command to generate the build (e.g. APK for Android)
- ionic cordova build (say no when asked for ios or android to build the web application)
For Android the result is an APK file in: C:\Users\theod\git\KPMG_Hackathon\App\platforms\android\build\outputs\apk

## Java backend
Requirements: Java 8, Maven
The insuredme folder contains the Maven project for the back end. In order to build run the following command:
- mvn clean package
The result is a jar file in target/ folder: insuredme-0.0.1-SNAPSHOT.jar

## RESTful web services:
- POST: /answer/add
- GET: /answer/all
- POST: /insurancetype/add
- GET: /insurancetype/all
- POST: /question/add [Question]
- POST: /question/addChoice [QuestionChoice]
- GET: /question/all
- GET: /question/type?questionType=
- GET: /question/choices?questionId=
- GET: /user/add
- GET: /user/all
- GET: /user/load?email=EMAIL&password=PASSWORD
- GET: /user/loadUser?email	
- GET: /quote/find?userId=1
- POST: /quote/add
- GET: /quote/all
- GET: /answer/findRegistrationNumberForQuote?quoteRequestId=3
