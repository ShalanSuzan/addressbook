# addressbook
A rest service to save user address information. 

## How to run the application?
1. Start clone the repository to access the code. 

> git clone https://github.com/Yardina/addressbook.git


2. Run the application useing pash script:   
> chmod +x run.sh && ./run.sh

Or if run it as spring-boot application from the development environment:
> mvn spring-boot:run

## How to access the database?
Addressbook contains a lightweight h2 database, that comes with own UI. You can directly access the database by typing in the browser:

URL: http://localhost:8090/console/  

You may even need to give extra details: 

```
Datasource url:  jdbc:h2:mem:addressbook
Table name: ADDRESS_BOOK
Query example: SELECT * FROM ADDRESS_BOOK  
```

 
## Rest services
Addessbook is a rest microservice with two endpoints where you add a new address and search for a given address. 
URI definitions:

1. POST ~/addressbooks 
- to save a new address information for a given name | update exiting one for a given name
- Http status : OK (200) 
- Http status : INTERNAL SERVER ERROR (500) 
                      
2. GET ~/addressbooks/{name} 
- get address by name
- Http status : OK (200)                            
- Http status : NOT FOUND (404)
                            
## Postman

Postman scripts is added to enhance backend verification:  
- Add new address book
- Get address 
 
File location: \addressbook\src\main\resources\postman\addressbook.postman_collection.json


