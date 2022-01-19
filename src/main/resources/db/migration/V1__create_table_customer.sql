CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL UNIQUE,
  name varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);