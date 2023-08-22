CREATE TABLE IF NOT EXISTS internal_employee
(
    id                  SERIAL PRIMARY KEY,
    first_name          VARCHAR,
    last_name           VARCHAR NOT NULL,
    registration_number VARCHAR,
    personal_email      VARCHAR NOT NULL UNIQUE,
    cin                 VARCHAR NOT NULL CHECK (cin ~ '^[0-9]+$'),
    cnaps_employee_id  INT,
    children_number     INTEGER DEFAULT 0 CHECK (children_number > -1),
    birth_date          DATE NOT NULL,
    entrance_date       DATE NOT NULL,
    departure_date      DATE,
    sex                 sex NOT NULL,
    csp                 csp NOT NULL,
    image               TEXT,
    professional_email  VARCHAR NOT NULL UNIQUE,
    address             VARCHAR NOT NULL,
    CONSTRAINT fk_cnaps_employee
        FOREIGN KEY (cnaps_employee_id)
        REFERENCES cnaps_employee (id)
);
