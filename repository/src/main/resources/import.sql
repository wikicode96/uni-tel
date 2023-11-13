-- Users
INSERT INTO users (first_name, last_name, email, password) VALUES ('username1', 'username1', 'example1@example.com', 'example');
INSERT INTO users (first_name, last_name, email, password) VALUES ('username2', 'username2', 'example2@example.com', 'example');

-- Airlines
INSERT INTO airlines (name, img_logo) VALUES ('FlyUS', 'flyus');
INSERT INTO airlines (name, img_logo) VALUES ('Air Herler', 'air-herler');
INSERT INTO airlines (name, img_logo) VALUES ('Adios Airlines', 'adios-airlines');
INSERT INTO airlines (name, img_logo) VALUES ('Caipira Airways', 'caipira-airways');
INSERT INTO airlines (name, img_logo) VALUES ('Juank Air', 'juank-air');

-- Flights
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (1, 'LV', 'VC', '2024-12-05');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (4, 'LS', 'LV', '2024-11-22');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (2, 'VC', 'LV', '2024-03-16');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (1, 'VC', 'LC', '2024-08-21');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (2, 'SF', 'LS', '2024-02-27');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (1, 'LS', 'VC', '2024-12-25');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (1, 'SF', 'LC', '2024-03-15');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (5, 'LV', 'LS', '2024-04-30');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (2, 'LC', 'VC', '2024-01-08');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (2, 'SF', 'LV', '2024-04-18');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (5, 'VC', 'LV', '2024-06-16');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (3, 'LC', 'VC', '2024-09-20');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (2, 'SF', 'LS', '2024-08-20');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (5, 'LC', 'LS', '2024-05-04');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (3, 'SF', 'VC', '2024-05-14');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (3, 'SF', 'LS', '2024-06-01');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (5, 'VC', 'LV', '2024-01-21');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (4, 'VC', 'LS', '2024-09-18');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (2, 'LC', 'SF', '2024-05-04');
INSERT INTO flights (id_airline, destination, origin, depart) VALUES (1, 'VC', 'SF', '2024-02-24');

-- Bookings
INSERT INTO bookings (id_flight, id_user, date) VALUES (7, 1, '2023-10-24');
INSERT INTO bookings (id_flight, id_user, date) VALUES (5, 1, '2023-12-02');
INSERT INTO bookings (id_flight, id_user, date) VALUES (3, 2, '2023-09-12');