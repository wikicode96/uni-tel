-- Create the database
CREATE DATABASE IF NOT EXISTS uni_tel;

-- Select the database
USE uni_tel;

-- Create the 'customers' table
CREATE TABLE IF NOT EXISTS customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);

-- Create the 'airlines' table
CREATE TABLE IF NOT EXISTS airlines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE,
    img_logo VARCHAR(255) UNIQUE
);

-- Create the 'flights' table
CREATE TABLE IF NOT EXISTS flights (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_airline INT,
    destination VARCHAR(255),
    origin VARCHAR(255),
    depart DATE,
    FOREIGN KEY (id_airline) REFERENCES airlines(id)
);

-- Create the 'bookings' table
CREATE TABLE IF NOT EXISTS bookings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_flight INT,
    id_customers INT,
    date DATE,
    FOREIGN KEY (id_flight) REFERENCES flights(id),
    FOREIGN KEY (id_customers) REFERENCES customers(id)
);

-- Customers
INSERT INTO customers (id, first_name, last_name, email, password) VALUES (1, 'fname', 'lname', 'example@example.com', 'example');

-- Airlines
INSERT INTO airlines (id, name, img_logo) VALUES (1, 'FlyUS', 'flyus');
INSERT INTO airlines (id, name, img_logo) VALUES (2, 'Air Herler', 'air-herler');
INSERT INTO airlines (id, name, img_logo) VALUES (3, 'Adios Airlines', 'adios-airlines');
INSERT INTO airlines (id, name, img_logo) VALUES (4, 'Caipira Airways', 'caipira-airways');
INSERT INTO airlines (id, name, img_logo) VALUES (5, 'Juank Air', 'juank-air');

-- Flights
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (1, 1, 'LV', 'VC', '2024-12-05');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (2, 4, 'LS', 'LV', '2024-11-22');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (3, 2, 'VC', 'LV', '2024-03-16');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (4, 1, 'VC', 'LC', '2024-08-21');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (5, 2, 'SF', 'LS', '2024-02-27');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (6, 1, 'LS', 'VC', '2024-12-25');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (7, 1, 'SF', 'LC', '2024-03-15');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (8, 5, 'LV', 'LS', '2024-04-30');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (9, 2, 'LC', 'VC', '2024-01-08');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (10, 2, 'SF', 'LV', '2024-04-18');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (11, 5, 'VC', 'LV', '2024-06-16');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (12, 3, 'LC', 'VC', '2024-09-20');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (13, 2, 'SF', 'LS', '2024-08-20');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (14, 5, 'LC', 'LS', '2024-05-04');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (15, 3, 'SF', 'VC', '2024-05-14');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (16, 3, 'SF', 'LS', '2024-06-01');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (17, 5, 'VC', 'LV', '2024-01-21');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (18, 4, 'VC', 'LS', '2024-09-18');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (19, 2, 'LC', 'SF', '2024-05-04');
INSERT INTO flights (id, id_airline, destination, origin, depart) VALUES (20, 1, 'VC', 'SF', '2024-02-24');

-- Bookings
INSERT INTO bookings (id, id_flight, id_customers, date) VALUES (1, 1, 1, '2023-10-24');