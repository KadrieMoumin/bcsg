The project was developed in Eclipse Kepler
Spring, Hibernate frameworks, MySQL database, and Maven build tool was used in the project.
There is a need to change the following configuration details in ApplicationContextConfigTest 
file and to create and insert the database and data into it. 


ApplicationContextConfigTest.java

<------edit the lines --->

dataSource.setUrl("jdbc:mysql://localhost:3306/bcsg"); >change the port if it is required
dataSource.setUsername("username");     > enter the username 
dataSource.setPassword("password"); 	> enter your password for mysql

MySQL 

<------------CREATE DATABASE---------->

CREATE DATABASE `bcsg`;
use database bcsg;
	
CREATE TABLE `bcsg`.`bank_detail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bank_name` VARCHAR(50) NULL,
  `card_number` VARCHAR(20) NULL,
  `expiry_date` DATE NULL,
  PRIMARY KEY (`id`)
 );

<------------------INSERT VALUES INTO THE DATABASE----------------->

insert into bank_detail
values(1,'HSBS Canda','5601-2345-3446-5678', STR_TO_DATE('11-2017', '%m-%Y'));
insert into bank_detail
values(2,'Royal Bank of Canda','4519-4532-4524-2456',STR_TO_DATE('10-2017', '%m-%Y'));
insert into bank_detail
values(3,'American Express','3786-7334-8965-345', STR_TO_DATE('12-2018', '%m-%Y'));
insert into bank_detail
values(4,'American Express','3586-7534-8955-355', STR_TO_DATE('10-2017', '%m-%Y'));


