
-- ArtVista database with demo paintings and users

DROP TABLE IF EXISTS payment CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS art CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS artist CASCADE;
DROP TABLE IF EXISTS admin CASCADE;

CREATE TABLE admin (
  a_id SERIAL PRIMARY KEY,
  a_name VARCHAR(30) NOT NULL,
  a_loginname VARCHAR(20),
  a_gender VARCHAR(10),
  a_email VARCHAR(30),
  a_password VARCHAR(50),
  a_phone VARCHAR(20),
  a_addrs TEXT
);

CREATE TABLE artist (
  artist_id SERIAL PRIMARY KEY,
  artist_loginname VARCHAR(20),
  artist_name VARCHAR(30) NOT NULL,
  artist_email VARCHAR(30),
  artist_password VARCHAR(50),
  artist_phone VARCHAR(20),
  artist_addrs TEXT,
  artist_gender VARCHAR(10)
);

CREATE TABLE customer (
  c_id SERIAL PRIMARY KEY,
  c_loginname VARCHAR(20),
  c_name VARCHAR(30) NOT NULL,
  c_email VARCHAR(30),
  c_password VARCHAR(50),
  c_phone VARCHAR(20),
  c_addrs TEXT,
  c_gender VARCHAR(10)
);

CREATE TABLE art (
  art_id SERIAL PRIMARY KEY,
  art_name VARCHAR(100) NOT NULL,
  price INTEGER NOT NULL,
  artist_id INTEGER REFERENCES artist(artist_id),
  verified BOOLEAN DEFAULT FALSE,
  image_path TEXT
);

CREATE TABLE orders (
  o_id SERIAL PRIMARY KEY,
  amount INTEGER NOT NULL,
  date DATE NOT NULL,
  art_id INTEGER REFERENCES art(art_id),
  artist_id INTEGER REFERENCES artist(artist_id),
  c_id INTEGER REFERENCES customer(c_id),
  status VARCHAR(30)
);

CREATE TABLE payment (
  p_id SERIAL PRIMARY KEY,
  o_id INTEGER REFERENCES orders(o_id),
  amount INTEGER,
  c_id INTEGER REFERENCES customer(c_id),
  method VARCHAR(25)
);

INSERT INTO admin(a_name, a_loginname, a_password, a_email, a_phone, a_addrs, a_gender)
VALUES ('Main Admin','admin1','admin123','admin@gmail.com','9999999999','Pune, Maharashtra','Male');

INSERT INTO artist(artist_loginname, artist_name, artist_email, artist_password, artist_phone, artist_addrs, artist_gender)
VALUES
('ritesh','Ritesh Painter','ritesh@example.com','ritesh@123','9876543210','Pune, Maharashtra','Male'),
('artist2','Second Artist','artist2@example.com','artist234','9123456780','Mumbai, Maharashtra','Female');

INSERT INTO customer(c_loginname, c_name, c_email, c_password, c_phone, c_addrs, c_gender)
VALUES
('cust1','Customer One','cust1@example.com','cust123','9090909090','Nashik, Maharashtra','Female'),
('cust2','Customer Two','cust2@example.com','cust2@example.com','cust234','8080808080','Ahmednagar, Maharashtra','Male');

INSERT INTO art(art_name, price, artist_id, verified, image_path)
VALUES
('Sunset Over River (Oil Painting)', 2500, 1, TRUE, 'sunset_river.jpg'),
('Village Evening Scene (Acrylic Painting)', 3000, 1, TRUE, 'village_evening.jpg'),
('Abstract Color Splash (Canvas Painting)', 1800, 1, FALSE, 'abstract_splash.jpg'),
('Mountain Sunrise (Landscape Painting)', 3500, 2, TRUE, 'mountain_sunrise.jpg'),
('Flower Bouquet (Watercolor Painting)', 2200, 2, TRUE, 'flower_bouquet.jpg');

INSERT INTO orders(amount, date, art_id, artist_id, c_id, status)
VALUES (2500, CURRENT_DATE, 1, 1, 1, 'CONFIRMED');

INSERT INTO payment(o_id, amount, c_id, method)
VALUES (1, 2500, 1, 'UPI');
