CREATE TABLE IF NOT EXISTS users (
    id NUMBER PRIMARY KEY auto_increment,
    name VARCHAR2(100),
    gym VARCHAR2(100),
    email VARCHAR2(100),
    password VARCHAR2(100),
    created_at DATETIME,
    updated_at DATETIME
);