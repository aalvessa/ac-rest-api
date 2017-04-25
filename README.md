# README #

### AC-REST-API 
* Anderson Alves de Sá - BR

* The project must be run with : mvn jetty:run
* I couldn't run the tests because of a problem with cdi and jetty plugin, the test classes are in the project, they can be run through eclipse.


# API #


###API WADL###

http://localhost:8080/ac-rest-api.wadl

### IMAGE ###

* GET - get all images | URI = http://localhost:8080/rest/product/image

* POST - creates a new image resource | URI = http://localhost:8080/rest/product/image | 
Headers - Content-Type application/json |
Body-raw :
{
  "description": "image 6"
}

* PUT - updates image resource | URI = http://localhost:8080/rest/product/image |
Headers - Content-Type application/json |
Body-raw :
{
    "id": 6, 
    "description": "image 7"
}

* DELETE - removes the image resource - URI = http://localhost:8080/rest/product/image/{imageId}


###PRODUCT###

* POST - creates a new product resource - URI - http://localhost:8080/rest/product |
Headers - Content-Type application/json |
Body-raw :
{
    "description": "product 1",
    "parentProduct": {"id":1},
	"images":[{"id":1},{"id":2}]
}

* PUT - updates product resource | URI - http://localhost:8080/rest/product |
Headers - Content-Type application/json |
Body-raw :
{
    "id": 8,
    "description": "product 6",
    "parentProduct": {"id":1},
	"images":[{"id":1},{"id":2}]
}

* DELETE - removes the product resource: | URI - http://localhost:8080/rest/product/{productID}


* GET - get all products excluding relationship | URI - http://localhost:8080/rest/product

* GET - get specific product excluding relationship | URI - http://localhost:8080/rest/product/{productID}

* GET - get all products with children | URI - http://localhost:8080/rest/product/withChild/

* GET - get specific product with children | URI - http://localhost:8080/rest/product/withChild/{productID}

* GET - get specific product with images | URI - http://localhost:8080/rest/product/withImages/{productID}

* GET - get all products with images | URI - http://localhost:8080/rest/product/withImages/

* GET - get children of a specific product | URI - http://localhost:8080/rest/product/children/{productID}

* GET - get images of a specific product | URI - http://localhost:8080/rest/product/images/{productID}