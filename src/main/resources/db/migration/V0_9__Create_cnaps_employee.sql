CREATE TABLE IF NOT EXISTS cnaps_employee
(
    id            SERIAL PRIMARY KEY,
    first_name    VARCHAR,
    last_name     VARCHAR NOT NULL,
    cnaps_number  VARCHAR NOT NULL
);