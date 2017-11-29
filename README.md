##Product Microservice
Product microservice helps us to add, update, delete and search a product.
Caching is done in this application to store data so that future requests to the same data are returned faster and do not require repeating same operations. Product details are cached when each function is performed, using the redis cache configurations.
Performs functions:
- To fetch all the product data, that can be used for consumer to know the list of products.
- To fetch the desired product with particular description, size, price or other attributes separately.
		- To update the product details and also to delete any existing product.

##URL's and function
Use Any Rest clients(REST API CLIENT,POSTMAN CLIENT etc) to access the REST end points of the application 
1.http://localhost:8080/api/product/ and POST Request method helps you to add a new product and persist the data in mysql db
    For example your Json input should as 
    	
    REQUEST BODY:	
   ``` 	
{
    "name":"Fsports",
    "description":"Footwear",
    "category":"Shoes for men",
    "price":5000000,
    "color":"White",
    "size":"3",
    "discount":0,
    "flavour":"NA",
    "activeflag":"true"
  }
```
2. http://localhost:8080/api/product/{productNumber} and GET Request method helps to fetch the persisted data from mysql db with respect to id
  	For example the response body :
  	```
  		{
			"productID": 9,
			"name": "Fsports",
			"size": "3",
			"color": "White",
			"description": "Footwear",
			"flavour": "NA",
			"activeflag": "true",
			"price": "5000000",
			"category": "Shoes for men",
			"discount": 0
		}
	```		
3. http://localhost:8080/api/product/deletebyId/{productNumber} and DELETE Request method helps to delete the data
	  Response body:
	  		
	  		``` 
	  		Product deleted
	  		```
4. http://localhost:8080/api/product/deletebyName/{productName} and DELETE Request method helps to delete the data
	  Response body:
	  		```
	  		Product deleted
	        ```
5. http://localhost:8080/api/product/updatebyID and PUT Request method helps to update the data
	
	```
   REQUEST BODY:		
	{
    "productID": 1,
    "name": "Fsports",
    "description": "Footwear",
    "size": "3",
    "flavour": "NA",
    "category": "Shoes for men",
    "activeflag": "true",
    "price": 5700000,
    "discount": 0,
    "color": "White"
  }
	
	  Response body:
	  		Product updated	

  	```	
 6. http://localhost:8080/api/product/updatebyName and PUT Request method helps to update the data
    
	REQUEST BODY:		
	```	
	{
        "name": "Fsports",
        "description": "Footwear",
        "size": "3",
        "flavour": "NA",
        "category": "Shoes for men",
        "activeflag": "true",
        "price": 5800000,
        "discount": 0,
        "color": "White"
    }
	
	  Response body:
	  		Product updated
	```
	  		
 7. http://localhost:8080/api/product/ and GET Request method helps to fetch all the persisted data from mysql db
  	For example the response body :
  	```
  	    {
				"id": 2,
				"productName": "mango",
				"productPrice": "90",
				"productGroup": "Fruits"
        }
	``	  		
  8. http://localhost:8080/api/product/getByName/{productName} and GET Request method helps to fetch the persisted data from mysql db with respect to name
  
  9. http://localhost:8080/api/product/getByDescription/{productDescription} and GET Request method helps to fetch the persisted data from mysql db with respect to description
  
  10. http://localhost:8080/api/product/getBySize/{productSize} and GET Request method helps to fetch the persisted data from mysql db with respect to size
   
  11.http://localhost:8080/api/product/getByFlavour/{productFlavour} and GET Request method helps to fetch the persisted data from mysql db with respect to flavour
  
  12. http://localhost:8080/api/product/getByCategory/{productCategory} and GET Request method helps to fetch the persisted data from mysql db with respect to category
  
  13. http://localhost:8080/api/product/getByActiveflag/{productActiveflag} and GET Request method helps to fetch the persisted data from mysql db with respect to ActiveFlag
  
  14. http://localhost:8080/api/product/getByPrice/{productPrice} and GET Request method helps to fetch the persisted data from mysql db with respect to price
  
  15. http://localhost:8080/api/product/getByDiscount/{productDiscount} and GET Request method helps to fetch the persisted data from mysql db with respect to Discount
  
  16. http://localhost:8080/api/product/getByColor/{productColor} and GET Request method helps to fetch the persisted data from mysql db with respect to Color


When try to fetch or update or delete a data that is not available in the DB you receive a error message 
	  	  		
	  	{
		"timestamp": 1482213918625,
		"status": 404,
		"error": "Not Found",
		"exception": 		"org.accn.product.exception.ProductNotFoundException",
		"message": "No such product: 1",
		"path": "/product/1"
		}	
	
	
	
	
Run MySQL 5.6 in Docker container:

~~~
docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=sa -d mysql:5.6

#To expose the port 3306
docker run --name comm_mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7
~~~

Check the log to make sure the server is running OK:
~~~
docker logs demo-mysql
~~~

###Accessing the mysql db 
running in docker to run queries connect using the following:
~~~
    docker exec -it test-mysql bash

    mysql -uroot -psa -h 172.17.0.20 -P 3306

~~~

Run demo application in Docker container and link to demo-mysql:

~~~
    docker run -p 8080:8080 --name demo-app --link demo-mysql:mysql -d pes/product
~~~

You can check the log by
~~~
docker logs demo-app
~~~
###Command to Run the Application with Profiles:
mvn spring-boot:run -Pdev -Dspring.profiles.active="prod"

CONFIG SERVER

Config server : http://localhost:8888

Config Properties : https://github.com/sreenivasd/microservices/productservice
		
		
		
		