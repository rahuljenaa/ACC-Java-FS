DROP DATABASE IF EXISTS springormdemos;
CREATE DATABASE springormdemos; 
USE springormdemos;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;


CREATE TABLE IF NOT EXISTS department (
  departmentCode int(11) unsigned NOT NULL AUTO_INCREMENT,
  departmentName varchar(20) DEFAULT NULL,
  description varchar(250),
  PRIMARY KEY (departmentCode)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS employee (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  salary double DEFAULT NULL,
  role varchar(20) DEFAULT NULL,
  insert_time datetime DEFAULT NULL,
  departmentCode int(11)  REFERENCES department(departmentCode),
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;


INSERT INTO department (departmentCode, departmentName,description) VALUES
	(101, 'MainFrames'  , 'This is description for MainFrame department'),
	(102, 'Dotnet'      , 'This is description for Dotnet department'),
	(103, 'Java'        , 'This is description for Java department');
commit;


INSERT INTO employee (id, name, role, insert_time, salary,departmentCode) VALUES
	(1001, 'MSD', 'Sr.Analyst', '2016-01-28', 100000,101),
	(1002, 'James', 'Sr.Analyst', '2016-01-28', 0,101),
	(1003, 'Rocky', 'Sr.Analyst', '2016-01-28', 12000,102);
commit;

