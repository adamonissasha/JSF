CREATE TABLE customer
(
    id    bigint auto_increment PRIMARY KEY NOT NULL,
    name VARCHAR(256)          NOT NULL,
    surname   VARCHAR(64)           NOT NULL,
    zipCode     int           NOT NULL,
    email      VARCHAR(64)           NOT NULL
);

INSERT INTO customer(name, surname, zipCode, email)
VALUES ('Sasha', 'Adamonis', 124982, 'sasha@gmail.com'),
       ('Masha', 'Ivanova', 123455, 'masha@gmail.com'),
       ('Ilya', 'Ignatjvich', 873198, 'ilya@gmail.com'),
       ('Matvey', 'Stremous', 248953, 'matt@gmail.com');