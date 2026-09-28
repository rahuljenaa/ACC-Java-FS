DROP DATABASE IF EXISTS springormdemos;
CREATE DATABASE springormdemos; 
USE springormdemos;

DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer (
  customerId int(11) unsigned NOT NULL AUTO_INCREMENT,
  customerName varchar(20) DEFAULT NULL,
  customerType varchar(20) DEFAULT NULL,
  billAmount double DEFAULT NULL,
  PRIMARY KEY (customerId)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

INSERT INTO customer (customerId, customerName, customerType, billAmount) VALUES
	(1001, 'Jack', 'Gold', 10000),
	(1002, 'Mary', 'Silver', 20000),
	(1003, 'John', 'Platnium', 8000),
	(1004, 'Joseph', 'Gold', 56000),
	(1005, 'Ram', 'Silver', 45000),
	(1006, 'Jerrif', 'Platnium', 80000),
	(1007, 'Justin', 'Gold', 92000),
	(1008, 'Noel', 'Silver', 34000),
	(1009, 'Killo', 'Platnium', 80000),
	(1010, 'Rupek', 'Gold', 10000),
	(1011, 'JAS', 'Silver', 20000),
	(1012, 'MSD', 'Platnium', 80000);
commit;
