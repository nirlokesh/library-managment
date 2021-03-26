DROP TABLE IF EXISTS Book;

CREATE TABLE Book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  count INT DEFAULT 0
);

INSERT INTO Book (name, description, count) VALUES
  ('All About Java', 'Written by John T. Includes deep understanding of java with examples.', 4),
  ('Spring Recepies', 'Written by David H. With greate expalination about hhow spring works and in depth concepts.', 3),
  ('Head first HTML', 'Written by Alakija. All you know about HTML is here.', 5);