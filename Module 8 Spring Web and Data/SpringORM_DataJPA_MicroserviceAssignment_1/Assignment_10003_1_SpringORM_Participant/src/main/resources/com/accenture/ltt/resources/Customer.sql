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
	(1001, 'Jack', 'D', 100000),
	(1002, 'Mary', 'D', 20000),
	(1003, 'John', 'P', 8000);
commit;