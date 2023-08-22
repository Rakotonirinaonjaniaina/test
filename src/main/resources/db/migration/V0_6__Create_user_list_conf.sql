CREATE TABLE IF NOT EXISTS "user"
(
    id       VARCHAR CONSTRAINT user_pk PRIMARY KEY DEFAULT uuid_generate_v4(),
    username VARCHAR NOT NULL UNIQUE,
    password TEXT NOT NULL
);
