CREATE TABLE IF NOT EXISTS "phone"
(
    id                     VARCHAR CONSTRAINT phone_pk PRIMARY KEY DEFAULT uuid_generate_v4(),
    employee_id            VARCHAR,
    value                  VARCHAR NOT NULL UNIQUE,
    CONSTRAINT phone_employee_fk FOREIGN KEY (employee_id) REFERENCES "employee" (id)
);
