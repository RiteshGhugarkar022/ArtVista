-- SQL schema for ArtVista (simplified)
CREATE TABLE IF NOT EXISTS admin (
  a_id SERIAL PRIMARY KEY,
  a_name VARCHAR(30) NOT NULL,
  a_loginname VARCHAR(20),
  a_gender VARCHAR(10),
  a_email VARCHAR(30) UNIQUE,
  a_password VARCHAR(50),
  a_phone VARCHAR(20),
  a_addrs TEXT
);

CREATE TABLE IF NOT EXISTS artist (
  artist_id SERIAL PRIMARY KEY,
  artist_loginname VARCHAR(20),
  artist_name VARCHAR(30) NOT NULL,
  artist_email VARCHAR(30) UNIQUE,
  artist_password VARCHAR(50),
  artist_phone VARCHAR(20),
  artist_addrs TEXT,
  artist_gender VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS customer (
  c_id SERIAL PRIMARY KEY,
  c_loginname VARCHAR(20),
  c_name VARCHAR(30) NOT NULL,
  c_email VARCHAR(30) UNIQUE,
  c_password VARCHAR(50),
  c_phone VARCHAR(20),
  c_addrs TEXT,
  c_gender VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS art (
  art_id SERIAL PRIMARY KEY,
  art_name VARCHAR(100) NOT NULL,
  price INTEGER NOT NULL,
  artist_id INTEGER REFERENCES artist(artist_id),
  verified BOOLEAN DEFAULT FALSE,
  image_path TEXT
);

CREATE TABLE IF NOT EXISTS orders (
  o_id SERIAL PRIMARY KEY,
  amount INTEGER NOT NULL,
  date DATE NOT NULL,
  art_id INTEGER REFERENCES art(art_id),
  artist_id INTEGER REFERENCES artist(artist_id),
  c_id INTEGER REFERENCES customer(c_id),
  status VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS payment (
  p_id SERIAL PRIMARY KEY,
  o_id INTEGER REFERENCES orders(o_id),
  amount INTEGER,
  c_id INTEGER REFERENCES customer(c_id),
  method VARCHAR(25)
);
