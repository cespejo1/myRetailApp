# myRetailApp
A Restful Service

 This is a Restful service that can retrieve product and price details by ID. It responds to a GET and PUT Request.

# The following technologies were used:
Java
Spring Boot
MongoDB
Maven

# Instructions for testing, running:
1. The Application responds to a GET request by at http://localhost:8082/product/13860428 and returns the followng JSON response:
{    "id": 13860428,    "name": "The Big Lebowski (Blu-ray)",    "price": 13.49}

2. The application responds to a PUT at http://localhost:8082/product/13860428 and with request body in the following format:
{ "value": 102.30, "currency_code": "USD" }
and updates the price of the prouct with the id # 13860428. Another GET request would return the following:
{    "id": 13860428,    "name": "The Big Lebowski (Blu-ray)",    "price": 102.30}

You can run this application with a machine with the technologies listed above. You can then test using Postman and
sending the GET and PUT requests mentioned above.

# Under the hood:
The project has two main POJO files, Product and ProductPrice. ProdcuctPrice interacts with the DB. 
The controller has two methods, getProduct and updatePrice. When the project is started, the myRetailApplication 
class starts the springboot app and inserts two productPrice documents into the DB. 



