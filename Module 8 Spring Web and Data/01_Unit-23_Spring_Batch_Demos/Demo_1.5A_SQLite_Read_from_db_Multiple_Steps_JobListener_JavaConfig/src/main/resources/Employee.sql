DROP DATABASE IF EXISTS spring_batch_demos;
CREATE DATABASE spring_batch_demos; 
USE spring_batch_demos;

DROP TABLE IF EXISTS employee;


CREATE TABLE IF NOT EXISTS employee (
  employeeId int(11) unsigned NOT NULL AUTO_INCREMENT,
  employeename varchar(20) DEFAULT NULL,
  designation varchar(20) DEFAULT NULL,
  salary double DEFAULT NULL,
  role varchar(20) DEFAULT NULL,
  dateOfJoining datetime DEFAULT NULL,
  departmentCode int(11),
  PRIMARY KEY (employeeId)
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8;


-- dont execute the below statements
INSERT INTO employee (employeeId, employeename,designation,dateOfJoining,departmentCode, salary) VALUES
	(1001, 'MSD',      'Sr.Analyst', '2016-01-01',101, 5000),
	(1002, 'James',    'Sr.Analyst', '2016-02-02',101, 6000),
	(1003, 'Rocky',    'Sr.Analyst', '2016-03-02',101, 7000),
	(1004, 'Fool',     'Sr.Analyst', '2017-04-04',102, 90000),
	(1005, 'CSGrads' , 'TeamLead',   '2017-05-28',102, 0),
	(1006, 'Mokka',    'TeamLead',   '2017-06-14',102, 120),
	(1007, 'Tim',      'TeamLead',   '2018-07-13',103, 20000),
	(1008, 'Dan',      'TeamLead',   '2018-08-13',104, 90000),
	(1009, 'Eric',     'TeamLead',   '2018-09-15',104, 50000),
	(1010, 'Julia',    'Manager',    '2015-10-14',104, 100000),
	(1011, 'Karen',    'Manager',    '2015-11-04',104, 900000),
	(1012, 'Cynthya',  'Sr.Analyst', '2015-12-09',104, 12000);
commit;







