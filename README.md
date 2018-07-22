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
#
# Structure for the `package` table : 
#
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
#
# Structure for the `package_product` table : 
#
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
#
# Structure for the `product` table : 
#
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
#
# Data for the `product` table  (LIMIT -489,500)
#
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
The application can be started by running the the following JAR from the [java_home]/bin/java directory -
  testwebservice-0.0.1-SNAPSHOT.jar

for example -
  "C:\Program Files (x86)\Java\jre1.8.0_171\bin\java" -Dserver.port=8080 -jar testwebservice-0.0.1-SNAPSHOT.jar 




* Cloud Native Microservices
  * Uses best practices for cloud native applications
  * OAuth2 User Authentication
  * Netflix OSS / Spring Cloud Netflix
  * Configuration Server
  * Service Discovery
  * Circuit Breakers
  * API Gateway / Micro-proxy
* Legacy Edge Gateway
  * Legacy application integration layer
  * Adapter for legacy systems to consume microservices
* Lazy Migration of Legacy Data
  * Microservice facades integrate domain data from legacy applications
  * Database records are siphoned away from legacy databases
  * Datasource routing enables legacy systems to use microservices as the system of record
* Strangler Event Architecture
  * Asset capture strategy uses events to guarantee single system of record for resources
  * Durable mirroring of updates back to legacy system
