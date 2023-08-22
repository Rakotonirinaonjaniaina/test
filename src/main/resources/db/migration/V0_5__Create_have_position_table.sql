CREATE TABLE IF NOT EXISTS "have_position"
(
    id          VARCHAR CONSTRAINT have_position_pk PRIMARY KEY DEFAULT uuid_generate_v4(),
    employee_id VARCHAR NOT NULL,
    position_id VARCHAR NOT NULL,
    CONSTRAINT have_position_employee_fk FOREIGN KEY (employee_id) REFERENCES "employee" (id),
    CONSTRAINT have_position_position_fk FOREIGN KEY (position_id) REFERENCES "position" (id)
);