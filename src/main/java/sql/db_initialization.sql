DROP TABLE IF EXISTS stocks.people_stock CASCADE;
DROP TABLE IF EXISTS stocks.people CASCADE;


CREATE TABLE stocks.people
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  date_of_birth DATETIME NOT NULL
);

CREATE TABLE stocks.people_stock
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person INT NOT NULL,
  stock VARCHAR(256) NOT NULL,
  FOREIGN KEY (person) REFERENCES people (ID)
);


INSERT INTO stocks.people (first_name,last_name,date_of_birth) VALUES ('Stephan', 'Stylianides', '1989/06/28');
INSERT INTO stocks.people (first_name,last_name,date_of_birth) VALUES ('Gabriela', 'Guardado', '1989/10/22');


INSERT INTO stocks.people_stock (ID, person, stock) VALUES (1, 1, 'QQQ');
INSERT INTO stocks.people_stock (ID, person, stock) VALUES (2, 1, 'SPY');
INSERT INTO stocks.people_stock (ID, person, stock) VALUES (3, 2, 'IWM');
INSERT INTO stocks.people_stock (ID, person, stock) VALUES (4, 2, 'TWTR');
