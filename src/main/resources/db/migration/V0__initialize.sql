CREATE TABLE toppings(
  id     BIGINT PRIMARY KEY AUTO_INCREMENT,
  name   VARCHAR(100)
);

CREATE TABLE ingredients(
  id     BIGINT PRIMARY KEY AUTO_INCREMENT,
  name   VARCHAR(100)
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
  name   VARCHAR(100)
);

CREATE TABLE product(
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  product_id    BIGINT,
  product_type  INTEGER,
  productId     BIGINT
);
