CREATE TABLE IF NOT EXISTS employee_cnaps
(
    id            SERIAL PRIMARY KEY,
    first_name    VARCHAR,
    last_name     VARCHAR NOT NULL,
    cnaps_number  VARCHAR NOT NULL,
    end_to_end_id VARCHAR NOT NULL
);