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