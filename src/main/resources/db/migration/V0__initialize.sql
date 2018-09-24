CREATE TABLE toppings(
  id     BIGINT PRIMARY KEY AUTO_INCREMENT,
  name   VARCHAR(100)
);

CREATE TABLE ingredients(
  id     BIGINT PRIMARY KEY AUTO_INCREMENT,
  name   VARCHAR(255)
);

CREATE TABLE pizzas(
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  pizzatype    INTEGER,
  crust        VARCHAR(255),
  cheese       VARCHAR(255),
  sauce        VARCHAR(255),
  toppings     VARCHAR(255),
  ingredients  VARCHAR(255)
);

CREATE TABLE pizzas_types(
  id     BIGINT PRIMARY KEY AUTO_INCREMENT,
  name   VARCHAR(255)
);

CREATE TABLE products(
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  productType   VARCHAR(255),
  productId     INTEGER
);

CREATE TABLE orders(
  id                   BIGINT PRIMARY KEY AUTO_INCREMENT,
  name                 VARCHAR(255),
  orderedProducts      VARCHAR(255)
);
