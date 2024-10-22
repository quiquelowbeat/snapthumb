CREATE TABLE users (
    uuid UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(320) NOT NULL UNIQUE,
    hashed_password CHAR(60) NOT NULL
);