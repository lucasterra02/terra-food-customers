CREATE TABLE purchase (
  id int NOT NULL AUTO_INCREMENT primary key,
  customer_id int NOT NULL,
  nfe varchar(255),
  price decimal(15,2) not null,
  created_at datetime not null,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE purchase_product (
    purchase_id int NOT NULL,
    product_id int NOT NULL,
    FOREIGN KEY (purchase_id) REFERENCES purchase(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    PRIMARY KEY (purchase_id, product_id)
);