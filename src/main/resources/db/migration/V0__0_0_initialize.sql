DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS ingredients;
DROP TABLE IF EXISTS hernate_sequence;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS pizza_types;

CREATE TABLE hibernate_sequence(
  id     INT PRIMARY KEY AUTO_INCREMENT,
  next_val BIGINT
);

CREATE TABLE toppings(
  id     BIGINT PRIMARY KEY AUTO_INCREMENT,
  pizzas_pizzatype_id BIGINT,
  toppings VARCHAR(255),
  name   VARCHAR(100)
);

CREATE TABLE ingredients(
  id             BIGINT PRIMARY KEY AUTO_INCREMENT,
  ingredients    VARCHAR(255),
  pizzas_pizzatype_id  BIGINT,
  name           VARCHAR(100)
);

CREATE TABLE pizzas(
  id      INT PRIMARY KEY AUTO_INCREMENT,
  pizzatype_id BIGINT,
  crust   varchar(255),
  cheese  varchar(255),
  sauce   varchar(255),
  toppings VARCHAR(255),
  ingredients VARCHAR(255)
);

CREATE TABLE cheeses (
    name VARCHAR(40),
    size ENUM('ROQUEFORT', 'MANCHEGO', 'CHEDDAR', 'NONE')
);

CREATE TABLE pizza_types(
  id    BIGINT PRIMARY KEY AUTO_INCREMENT,
  name   VARCHAR(100)
);

CREATE TABLE product(
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  product_id    BIGINT,
  product_type  INTEGER,
  productId     BIGINT
);
