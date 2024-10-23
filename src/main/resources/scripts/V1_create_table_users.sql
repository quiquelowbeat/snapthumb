CREATE TABLE users (
    uuid UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(320) NOT NULL UNIQUE,
    password CHAR(60) NOT NULL,
    registered_at TIMESTAMP WITHOUT TIME ZONE NOT NULL
);

COMMENT ON TABLE users IS 'Stores user account information';
COMMENT ON COLUMN users.uuid IS 'Unique identifier for the user';
COMMENT ON COLUMN users.name IS 'User''s first name';
COMMENT ON COLUMN users.last_name IS 'User''s last name';
COMMENT ON COLUMN users.email IS 'User''s email address';
COMMENT ON COLUMN users.password IS 'Hashed password for user authentication';
COMMENT ON COLUMN users.registered_at IS 'Timestamp when the user account was registered, not updatable';