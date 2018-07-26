DROP TABLE IF EXISTS stocks.quotes CASCADE;

CREATE TABLE stocks.quotes
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  symbol VARCHAR(256) NOT NULL,
  time DATETIME NOT NULL,
  price decimal(10,0) NOT NULL
);
