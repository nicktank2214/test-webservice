# test-webservice Microservices
This test application is a Spring microservice example for managing packages of products.

# MySQL Database
The test application uses a MySQL database which can be built by running the following script -

# SQL Manager for MySQL 5.3.1.7
# ---------------------------------------
# Host     : localhost
# Port     : 3307
# Database : testdb
CREATE DATABASE `testdb`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';
USE `testdb`;

CREATE TABLE `package` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) COLLATE latin1_swedish_ci DEFAULT NULL,
  `description` VARCHAR(200) COLLATE latin1_swedish_ci DEFAULT NULL,
  `price` DECIMAL(13,2) DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`) COMMENT '',
  UNIQUE INDEX `id` USING BTREE (`id`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=22 AVG_ROW_LENGTH=5461 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT=''
;

CREATE TABLE `package_product` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `package_id` INTEGER(11) DEFAULT NULL,
  `product_id` VARCHAR(20) COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`) COMMENT '',
  UNIQUE INDEX `id` USING BTREE (`id`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=90 AVG_ROW_LENGTH=3276 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT=''
;

CREATE TABLE `product` (
  `id` VARCHAR(20) COLLATE latin1_swedish_ci NOT NULL,
  `name` VARCHAR(200) COLLATE latin1_swedish_ci DEFAULT NULL,
  `usdprice` DECIMAL(13,2) DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`) COMMENT '',
  UNIQUE INDEX `dd` USING BTREE (`id`) COMMENT ''
)ENGINE=InnoDB
AVG_ROW_LENGTH=1638 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT=''
;

INSERT INTO `product` (`id`, `name`, `usdprice`) VALUES
  ('500R5EHvNlNB','Gold Coin',249.00),
  ('7dgX6XzU3Wds','Sword',899.00),
  ('7Hv0hA2nmci7','Knife',349.00),
  ('8anPsR2jbfNW','Silver Coin',50.00),
  ('DXSQpv6XVeJm','Helmet',999.00),
  ('IJOHGYkY2CYq','Bow',649.00),
  ('IP3cv7TcZhQn','Platinum Coin',399.00),
  ('PKM5pGAh9yGm','Axe',799.00),
  ('VqKb4tyj9V6i','Shield',1149.00),
  ('XXXYYYZZZ','Test Product A',99889.00);
COMMIT;


# Run the Spring Boot
Import the applications into Eclipse and run the Spring Boot Application program - 

com.nicktank.microservice.MicroserviceApplication.java

The application will use the following parameters to connect to the MySQL database -

spring.datasource.url=jdbc:mysql://localhost:3307/testdb

spring.datasource.username=

spring.datasource.password=

server.port=8080





# Calling web service requests

* Example of CREATE a package request - 

POST http://localhost:8080/package

with JSON parameters -

{
    "name": "Package 1",
    "description": "Package 1",
    "price": 0
}
    
    
* Example of RETRIEVE a package by id request - 

GET http://localhost:8080/package/1

* Example of RETRIEVE a package for a currency by id request - 

GET http://localhost:8080/package/1/GBP


* Example of UPDATE a package AND add/remove package products by id request - 

PUT http://localhost:8080/package/1

with JSON parameters -

{
    "name": "Package 1",
    "description": "Package 1",
    "packageProducts": [
    {
        "productid": "7dgX6XzU3Wds"
    },
    {
        "productid": "7Hv0hA2nmci7"
    },
    {
        "productid": "8anPsR2jbfNW"
    }
    ]
}

* Example of DELETE a package AND add/remove package products by id request - 

DELETE http://localhost:8080/package/1

* Example of LIST ALL packages request - 

GET http://localhost:8080/package/list

OR with Paging -

GET http://localhost:8080/package/list?page=0&size=20

