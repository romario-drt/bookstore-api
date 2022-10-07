-- Insert Customers (5)
INSERT into customer (creation_date, update_date, email, firstname, lastname, password, is_admin, version)
VALUES (now(), now(), 'romario@hotmail.com', 'romario', 'Teixeira', 'password', true, 0);
INSERT into customer (creation_date, update_date, email, firstname, lastname, password, is_admin, version)
VALUES (now(), now(), 'Pedro@hotmail.com', 'Pedro', 'Bellandi', 'password', false, 0);
INSERT into customer (creation_date, update_date, email, firstname, lastname, password, is_admin, version)
VALUES (now(), now(), 'Suade@hotmail.com', 'Suade', 'Vale', 'password', false, 0);
INSERT into customer (creation_date, update_date, email, firstname, lastname, password, is_admin, version)
VALUES (now(), now(), 'Hode@hotmail.com', 'hode', 'Kyle', 'password', false, 0);
INSERT into customer (creation_date, update_date, email, firstname, lastname, password, is_admin, version)
VALUES (now(), now(), 'Loke@hotmail.com', 'Loke', 'Woods', 'password', false, 0);

-- Insert genres (10)
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (1, now(), now(), 'ADVENTURE', 0); --done
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (2, now(), now(), 'MYSTERY', 0); --
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (3, now(), now(), 'FANTASY', 0);
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (4, now(), now(), 'HORROR', 0);
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (5, now(), now(), 'ROMANCE', 0);
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (6, now(), now(), 'NOVEL', 0);
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (7, now(), now(), 'SUSPENSE', 0);
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (8, now(), now(), 'DRAMA', 0);
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (9, now(), now(), 'HISTORY', 0);
INSERT INTO genre (id, creation_date, update_date, genre, version) VALUES (10, now(), now(), 'POETRY', 0);

--insert authors
INSERT INTO author (id, creation_date, update_date, version, name) VALUES (1, now(), now(), 0, 'jack London');
INSERT INTO author (id, creation_date, update_date, version, name) VALUES (2, now(), now(), 0, 'Yann Martel');
INSERT INTO author (id, creation_date, update_date, version, name) VALUES (3, now(), now(), 0, 'Alexandre Dumas');
INSERT INTO author (id, creation_date, update_date, version, name) VALUES (4, now(), now(), 0, 'Michael Connelly');
INSERT INTO author (id, creation_date, update_date, version, name) VALUES (5, now(), now(), 0, 'Sir Arthur Conan Doyle');

-- Insert Books
INSERT INTO book (id, genre_id, creation_date, update_date, version, condition, isbn, price, quantity, published_date,
                  title, img)
VALUES (1, 1, now(), now(), 0, 'NEW', 9781512395822, 5.96, 12, '2020-12-21',
        'The Call of the Wild ', 'https://m.media-amazon.com/images/I/41JNWeZqnsL._SX336_BO1,204,203,200_.jpg');

INSERT INTO book (id, genre_id, creation_date, update_date, version, condition, isbn, price, quantity, published_date,
                  title, img)
VALUES (2, 1, now(), now(), 0, 'NEW', 9781512394322, 8.99, 3, '2003-04-01', 'Life Of PI',
        'https://m.media-amazon.com/images/I/51rxEvLljUL._SX322_BO1,204,203,200_.jpg');

INSERT INTO book (id, genre_id, creation_date, update_date, version, condition, isbn, price, quantity, published_date,
                  title, img)
VALUES (3, 10, now(), now(), 0, 'USED', 9781505234725, 7.24, 1, '2014-12-05', 'The Three Musketeers',
        'https://m.media-amazon.com/images/I/41TxXqToCCL._SX348_BO1,204,203,200_.jpg');

INSERT INTO book (id, genre_id, creation_date, update_date, version, condition, isbn, price, quantity, published_date,
                  title, img)
VALUES (4, 1, now(), now(), 0, 'USED', 9781512395822, 4.99, 5, '2022-10-03', 'The Count of Monte Cristo',
        'https://m.media-amazon.com/images/I/51wuk77r6UL.jpg');

INSERT INTO book (id, genre_id, creation_date, update_date, version, condition, isbn, price, quantity, published_date,
                  title, img)
VALUES (5,2, now(), now(), 0, 'NEW', 9780316485616, 16, 2, '2019-10-22', 'The Night Fire',
        'https://m.media-amazon.com/images/I/41zqZwXZ-WL._SX325_BO1,204,203,200_.jpg');

INSERT INTO book (id, genre_id, creation_date, update_date, version, condition, isbn, price, quantity, published_date,
                  title, img)
VALUES (6,2, now(), now(), 0, 'USED', 9780316377300,11.99, 7, '2021-11-09', 'The Dark Hours',
        'https://m.media-amazon.com/images/I/51H+yDcBXhL.jpg');

INSERT INTO book (id, genre_id, creation_date, update_date, version, condition, isbn, price, quantity, published_date,
                  title, img)
VALUES (7,2, now(), now(), 0, 'NEW', 9781508475316, 4.95, 1, '2020-12-07', 'The Adventures of Sherlock Holmes',
        'https://m.media-amazon.com/images/I/516dZVA7rQL._SX346_BO1,204,203,200_.jpg');

--insert Book_authors
INSERT INTO book_authors(book_id, authors_id) VALUES (1, 1);
INSERT INTO book_authors(book_id, authors_id) VALUES (2, 2);
INSERT INTO book_authors(book_id, authors_id) VALUES (3, 3);
INSERT INTO book_authors(book_id, authors_id) VALUES (4, 3);
INSERT INTO book_authors(book_id, authors_id) VALUES (5, 4);
INSERT INTO book_authors(book_id, authors_id) VALUES (6, 4);
INSERT INTO book_authors(book_id, authors_id) VALUES (7, 5);