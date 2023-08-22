CREATE TABLE IF NOT EXISTS "position"
(
    id          VARCHAR CONSTRAINT position_pk PRIMARY KEY DEFAULT uuid_generate_v4(),
    name        VARCHAR NOT NULL UNIQUE
);