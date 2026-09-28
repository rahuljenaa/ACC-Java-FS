

CREATE DATABASE IF NOT EXISTS user_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE user_db;

CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

INSERT INTO users (username, password)VALUES ('alice', 'securePassword123');
INSERT INTO users (username, password)VALUES ('user', 'securePassword123');