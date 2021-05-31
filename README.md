# Credit Card Application

## Design

This project implements a credit card application which uses the multitier architecture.

In this client-server architecture, all of the information is distributed across multiple layers.
In a logical multilayer architecture with an object-oriented design, the following four are the most common:
 - Presentation layer (this is the UI or view layer)
 - Application layer (this is the service or controller layer)
 - Business layer (this is the layer where all of the client specific business logic sits)
 - Data access layer (this is the persistence layer, logging, networking, and other services which are required to support a particular business layer)


User Interface : 
<img width="1184" alt="Screenshot 2021-05-31 at 18 26 04" src="https://user-images.githubusercontent.com/85080220/120225866-f1c5d580-c23d-11eb-80fd-29ff36fc9eaf.png">


## Features

The application supports :
 1. Adding/creating new credit card in the system by taking name, card number, and limit(optional) from the user
    - Card numbers are validated using Luhn 10 Algorithm
    - New cards start with a £0 balance
    - For card numbers in-compatible with Luhn 10, error is returned.
     
 2. Displays all the existing credit cards in the system
 

### Swagger URL and definition : 

    http://localhost:8080/swagger-ui.html
    
<img width="1001" alt="Screenshot 2021-05-31 at 18 26 44" src="https://user-images.githubusercontent.com/85080220/120226143-86303800-c23e-11eb-9866-70a1d8512a00.png">


### Installation : 

This project requires JDK 8 and maven for building and testing it. 

Install Java on linux using this command:

    sudo apt-get install openjdk-8-jdk
    
Install maven    
    
    sudo apt-get install maven
 
### Building : 
 
    mvn clean package

Code coverage is executed by Jacoco in the build process. 

The results are in an HTML page generated under :
    
    target/site/jacoco/index.html

### Testing : 

    mvn clean test
    
Test results are located at:
    
    target/surefire-reports    


### Running :

    java -jar target/creditcard-0.0.1-SNAPSHOT.jar
    (make sure port 8080 is available)
    
or
    
    The simplest way to run the app is by using the Spring-boot maven plugin:
    ./mvnw spring-boot:run
  
### Builing and running in docker :

    docker build -t swati/credit-card . 
    docker run -p 8080:8080 swati/credit-card

### Angular client URL:

    http://localhost:8080 
  
     
## REST CURL commands and examples

### Some valid card numbers

    5038569482088860
    349103112508868
    6011873475611998302
    2720995793778198

### Create a valid credit card add request

    curl --request POST  --url http://localhost:8080/creditcards \
         --header 'content-type: application/json'  --header 'Accept: application/json' \
         --data '{"creditCardNumber":"6374467634328732","name":"Monica Geller","creditLimit":1000}'	

    {
        "creditCardNumber": "6374467634328732",
        "name": "Monica Geller",
        "creditLimit": 1000.0,
        "remainingCredit": 0.0
    }
    

### Create an invalid Luhn 10 credit card request

    curl --request POST  --url http://localhost:8080/creditcards \
	 --header 'content-type: application/json'  --header 'Accept: application/json' \
	 --data '{"creditCardNumber":"0000873475611998302","name":"Rachel Green","creditLimit":2000}'
     
     {
       "message" : "Credit card number is not valid"
     }
     
### Get all credit cards

    curl -X GET --header 'Accept: application/json' 'http://localhost:8080/creditcards'   
    
    

## Limitations and Scope for Improvements
   - This application is not in a production ready state. 
   - Basic tests have been designed with the intent to showcase the implementation of some useful functional and non-functional requirements. But surely there is room to add a comprehensive suite of tests.
   - Error messages can be improved.
   
 
    
