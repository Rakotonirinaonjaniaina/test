CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'sex') THEN
        CREATE TYPE sex AS ENUM ('H', 'F');
    END IF;
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'csp') THEN
        CREATE TYPE csp AS ENUM ('AGRICULTURAL_WORKERS', 'CRAFTSMEN_AND_ARTISANS', 'TRADERS_AND_MERCHANTS', 'CIVIL_SERVANTS_AND_PROFESSIONALS', 'UNSKILLED_LABORERS');
    END IF;
END $$;

CREATE TABLE IF NOT EXISTS "employee"
(
    id                  VARCHAR CONSTRAINT employee_pk PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name          VARCHAR,
    last_name           VARCHAR NOT NULL,
    registration_number VARCHAR ,
    personal_email      VARCHAR NOT NULL UNIQUE,
    cin                 VARCHAR NOT NULL CHECK (cin ~ '^[0-9]+$'),
    cnaps               VARCHAR,
    cnaps_employee_id   INT,
    children_number     INTEGER DEFAULT 0 CHECK (children_number > -1),
    birth_date          DATE NOT NULL,
    entrance_date       DATE NOT NULL,
    departure_date      DATE,
    sex                 sex NOT NULL,
    csp                 csp NOT NULL,
    image               TEXT,
    professional_email  VARCHAR NOT NULL UNIQUE,
    address             VARCHAR NOT NULL,
    end_to_end_id       INT
);
