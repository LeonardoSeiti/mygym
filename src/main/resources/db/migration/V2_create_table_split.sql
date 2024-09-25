CREATE TABLE IF NOT EXISTS split (
    id NUMBER PRIMARY KEY auto_increment,
    "type" VARCHAR2(100),
    "description" VARCHAR2(150),
    created_at DATETIME,
    updated_at DATETIME
);