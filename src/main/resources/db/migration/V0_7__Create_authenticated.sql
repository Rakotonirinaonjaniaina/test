CREATE TABLE IF NOT EXISTS "session"
(
    id         VARCHAR CONSTRAINT session_pk PRIMARY KEY DEFAULT uuid_generate_v4(),
    session_id VARCHAR NOT NULL,
    timeout    TIMESTAMP,
    user_id    VARCHAR,
    CONSTRAINT session_user_fk FOREIGN KEY (user_id) REFERENCES "user" (id)
);
