-- Insert Customers 5
INSERT into customer (creation_date, update_date, email,firstname,lastname,password,is_admin,version)
VALUES ( now(),now(),'romario@hotmail.com','romario','Teixeira','password',true, 0);
INSERT into customer (creation_date, update_date, email,firstname,lastname,password,is_admin,version)
VALUES ( now(),now(),'Pedro@hotmail.com','Pedro','Bellandi','password',false, 0);
INSERT into customer (creation_date, update_date, email,firstname,lastname,password,is_admin,version)
VALUES ( now(),now(),'Suade@hotmail.com','Suade','Vale','password',false, 0);
INSERT into customer (creation_date, update_date, email,firstname,lastname,password,is_admin,version)
VALUES ( now(),now(),'Hode@hotmail.com','hode','Kyle','password',false, 0);
INSERT into customer (creation_date, update_date, email,firstname,lastname,password,is_admin,version)
VALUES ( now(),now(),'Loke@hotmail.com','Loke','Woods','password',false, 0);

-- Insert genres (10)
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'ADVENTURE', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'MYSTERY', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'FANTASY', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'HORROR', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'ROMANCE', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'NOVEL', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'SUSPENSE', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'DRAMA', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'HISTORY', 0);
INSERT INTO genre (creation_date,update_date,genre,version) VALUES (now(),now(),'POETRY', 0);
