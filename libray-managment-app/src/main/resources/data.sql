DROP TABLE IF EXISTS Book;

CREATE TABLE Book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(100) NOT NULL,
  count INT DEFAULT 0
);

INSERT INTO Book (name, description, count) VALUES
  ('All About Java', 'Written by John T. Includes deep understanding of java with examples.', 4),
  ('Spring 2.0', 'Written by David H. With greate expalination about how spring works.', 3),
  ('HTML&CSS', 'Written by Phillip Q. Learn to create and design web pages with html and CSS.', 4),
  ('Spring boot', 'Written by Holger M. With greate expalination about how spring boot works.', 3),
  ('Angular 2+', 'Written by Heiko G. All new angular concepts and examples.', 4),
  ('.Net', 'Written by Reduane H. Learn to build APIs with .Net.', 3),
  ('Head first JSP', 'Written by Alakija. All you know about HTML is here.', 5),
  ('C & C++', 'Written by Sameer. Explore with programming with c and c++.', 5);
  
DROP TABLE IF EXISTS BorrowList;

CREATE TABLE BorrowList (
  id INT AUTO_INCREMENT,
  username VARCHAR(250) NOT NULL,
  bookId VARCHAR(250) NOT NULL,
  PRIMARY KEY (username, bookId)
);
