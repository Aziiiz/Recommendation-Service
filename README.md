# About the Task
## Introduction
At bigin, We collect and handle user's activity logs on the e-commerce webpage. Below
this paragraph is examples of data we collect. The data can be stored in cookies or
local storage and placed in the Request body to be called upon request call..
* User identification ID - UUID.
* Array of porduct Ids user viewed - ["991","987","990","100"].
* Array of keywords searched by the user - ["청바지", "반바지", "pk티셔츠"] (translation:
  ['Jean', 'Short', 'pk T-shirt']).
* Array of porduct Ids user put in their shopping carts - ["999", "990", "870"].
* Array of product Ids user purchased - ["900", "901", "992"]  

## Requirements
1. Return Product Information by keyword searched ~ API
2. Return Product Inforamtion By ProductIDs ~ API
3. Return Product Information By user shopping cart ~API

## Data Source

**product.csv**

## Tech Stack:
**JAVA SpringBooot, MVC architecture, H2 database, JPA with Hibernate, Lombok**


### Explanations
* Program runs on **8080** port
* all API's start from **/api/**
* Swagger implemented endpoint **http://localhost:8080/swagger-ui.html**



2.Basically on database side i have  one table is for Product.

### PRODUCT table

| **product_id** | **name** | **advertiser_id** | **product_code** | **device_type**| **price** | **discount_price** |
| -----------|------------------|----------------|--------|--------|---------|--------|

<br />



## About APIs

1. For Product By Keyword API it mainly returns most similar products by keywords
```
curl -X POST "http://localhost:8080/api/recommendation/keyword" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"keywords\": [ \"cordura\" ], \"user_id\": \"12345\"}"

  [
    {
        "product_id": 24036,
        "advertiser_id": "ZYDTMTSMED-1",
        "product_code": "119",
        "name": "CORDURA 2PK DAYPACK BLACK",
        "device_type": 1,
        "price": 69000,
        "discount_price": 69000
    }
 ]
```

2. For product by Product ids API it mainly returns most similar products by Product id
```
curl -X POST "http://localhost:8080/api/recommendation/product-id" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"product_id\": [ \"5\" ], \"user_id\": \"12345\"}"
  [
    {
        "product_id": 6,
        "advertiser_id": "0Q4KU4K90G-2",
        "product_code": "P000000J",
        "name": "샘플상품 2",
        "device_type": 2,
        "price": 10000,
        "discount_price": 10000uuuu
    }
  ]  
```

3. For product by user shopping cart API it mainly returns most similar products by Product id which is in users shopping cart
```
curl -X POST "http://localhost:8080/api/recommendation/shopping-cart" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"product_id\": [ \"5\" ], \"user_id\": \"12345\"}"

  [
    {
        "product_id": 5,
        "advertiser_id": "0Q4KU4K90G-2",
        "product_code": "P000000I",
        "name": "샘플상품 1",
        "device_type": 2,
        "price": 5000,
        "discount_price": 5000
    }
  ]  
```


## Class diagram

![class diagram](class_diagram.png)



## Additional Skills
 1. Soft Skills
    * Open to learning
    * Open for feedback  
    * Accepting of change
    * Good communicators
 2. Hard Skills
    * Designing Database Architecture

 
## Discussion

As task required implement mock recommendation API. So that is why it was used SQL based memory database and got similar products with LIKE query basically. However in order to get more accuracy recommendation data, 
using NoSQL database mainly Elasticsearch is more suitable for these task requirements. Because Elasticsearch provides scoring and multiple filtering features.

# Summary
- [x] Implementing 3 APIs.
- [x] API Documentation.
- [x] Class diagram
- [x] Provide README
- [x] Submit on Github

