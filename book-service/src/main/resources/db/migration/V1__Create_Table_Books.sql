CREATE TABLE book (
  id SERIAL NOT NULL PRIMARY KEY,
  author text,
  launch_date Date NOT NULL,
  price decimal NOT NULL,
  title text
);
