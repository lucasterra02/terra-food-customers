CREATE TABLE product (
  id int NOT NULL AUTO_INCREMENT primary key,
  name varchar(255) NOT NULL,
  price decimal(10,2) NOT NULL,
  status varchar(100) NOT NULL,
  customer_id int not null,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);