# addressbook
A rest service to save user address information. 

## database
Addressbook has a lightweight h2 database, that can be accessed via browser:

Link: http://localhost:8090/console/. The database  
Datasource url:  jdbc:h2:mem:addressbook
Table name: ADDRESS_BOOK
Query example: SELECT * FROM ADDRESS_BOOK  
 
 
## Rest services
Addessbook is a rest microservice with two endpoints:

1. POST 
- /addressbooks 
- to save a new address information for a given name | update exiting one for a given name
- Http status : OK (200) 
- Http status : INTERNAL SERVER ERROR (500) 
                      
2. GET 
- /addressbooks/{name} 
- get address by name
- Http status : OK (200)                            
- Http status : NOT FOUND (404)
                            
## Postman

Two postman scripts are added to enhance test use-ability:
- Add new address book
- Get address 
 
File location: \addressbook\src\main\resources\postman\addressbook.postman_collection.json

## Run application

To run the application execute: 

- linux environment: run.sh script  
- Windows environment: mvn spring-boot:run (under project main folder).  
