# BookApi
>REST

## Table of elements
* [Description](#description)
* [Technogy Stack](#technogy-stack)
* [App Testing](#app-testing)

## Description
>Application pretend communication between client and server via the REST API.

## Technogy Stack
* Java
* Spring MVC
* Jackson
* Dependency injection
* Tomcat
* Postman (testing)


## Application Testing

### Display list of objects: method „GET” [server:port]/books  
Exempli gratia: http://localhost:8080/books<br>
Returns list of all books.

JSON:
````json
[{
	"id": 1,
	"isbn": "9788328302341",
	"title": "Clean Code",
	"author": "Robert C. Martin",
	"publisher": "Helion",
	"type": "programming"
}, {
	"id": 2,
	"isbn": "9788328365728",
	"title": "Test-Driven Development",
	"author": "Kent Beck",
	"publisher": "Helion",
	"type": "programming"
}, {
	"id": 3,
	"isbn": "9788328345768",
	"title": "Effective Java",
	"author": "Joshua Bloch",
	"publisher": "Helion",
	"type": "programming"
}]
````
### Display object per id: method „GET” [server:port]/books/{id}  
Exempli gratia: http://localhost:8080/books/2<br>
Returns chosen book.

JSON:
````json
[{
	"id": 1,
	"isbn": "9788328302341",
	"title": "Clean Code",
	"author": "Robert C. Martin",
	"publisher": "Helion",
	"type": "programming"
}]
````
### Add object: method „POST” [server:port]/books/{id}  

POSTMAN can be used to pass an object to database in JSON format:
POST http://localhost:8080/books<br>
Headers: Key=”Content-Type”<br> Value=”application/json”
Body (JSON):
````json
[{
	"isbn": "9788328331303",
	"title": "The Pragmatic Programmer",
	"author": "Andrew Hunt, David Thomas",
	"publisher": "Helion",
	"type": "programming"
}]
````
Succesfull request get response: 'status 200'.
Added book can be displayed on the: [server:port]/books/ 
Exempli gratia: http://localhost:8080/books/
REMEMBER TO CREATE NO ARGUMENTS CONCTRUCTOR!!

### Update object: method „PUT” [server:port]/books/{id}  

POSTMAN can be used to pass updated object to database in JSON format:
PUT http://localhost:8080/books/{id}<br>
Headers: Key=”Content-Type”<br> Value=”application/json”
Body (JSON):
````json
[{
	"id": 3,
	"isbn": "9788328345768",
	"title": "Effective Java",
	"author": "Joshua Bloch",
	"publisher": "Helion",
	"type": "programming"
}]
````
Display amended book on: [server:port]/books/{id}  
Exempli gratia: http://localhost:8080/books/3


### Delete object: method „DELETE” [server:port]/books/{id}  

Use POSTMAN to pass deletion request in JSON format:
DELETE http://localhost:8080/books/{id}<br>
Headers: Key=”Content-Type”<br> Value=”application/json”
Body (JSON):
````json
[{
	"id": 1,
	"isbn": "9788328302341",
	"title": "Clean Code",
	"author": "Robert C. Martin",
	"publisher": "Helion",
	"type": "programming"
}]
````
Display deleted book per id: [server:port]/books/{id}  
Exempli gratia: http://localhost:8080/books/4<br>
There will be no result if deletion was completed.
