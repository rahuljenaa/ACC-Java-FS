
-- ------------------------------------------------------------
-- Database setup for Employee schema (single table: employees)
-- This script is idempotent: it DROPs and CREATEs required tables
-- ------------------------------------------------------------

CREATE DATABASE IF NOT EXISTS employee_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE employee_db;

-- ------------------------------------------------------------
-- Clean up existing objects to allow clean re-runs
-- ------------------------------------------------------------

DROP TABLE IF EXISTS employees;

-- ------------------------------------------------------------
-- Create core table: employees
--  - employee_id is the PRIMARY KEY
--  - department_code is kept as an integer attribute (no FK)
-- ------------------------------------------------------------

CREATE TABLE IF NOT EXISTS employees (
  employee_id INT NOT NULL,
  employee_name VARCHAR(100) NOT NULL,
  salary DECIMAL(10,2) NOT NULL,
  department_code INT NOT NULL,
  PRIMARY KEY (employee_id)
) ENGINE=InnoDB;

-- ------------------------------------------------------------
-- Seed employees with sample data
-- ------------------------------------------------------------

INSERT INTO employees (employee_id, employee_name, salary, department_code) VALUES
  (1001, 'John Doe', 50000.00, 10),
  (1002, 'Jane Smith', 60000.00, 20),
  (1003, 'Alice Johnson', 72000.00, 10),
  (1004, 'Bob Williams', 48000.00, 30),
  (1005, 'Carol Brown', 83000.00, 40);


