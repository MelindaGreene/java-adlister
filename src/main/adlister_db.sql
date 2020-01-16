CREATE DATABASE adlister_db;
USE adlister_db;

CREATE TABLE users(
    id INT,
    username varchar(50),
    email varchar(50),
    password varchar(50)

);

CREATE TABLE ads(
     id INT ,
     user_id varchar(50),
     title varchar(50),
     description varchar(50),
     CONTENT TEXT NOT NULL,
     PRIMARY KEY(user_id)

)



