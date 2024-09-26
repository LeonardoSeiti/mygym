CREATE TABLE IF NOT EXISTS cliente (
    id NUMBER PRIMARY KEY auto_increment,
    name VARCHAR2(100),
    gym VARCHAR2(100),
    email VARCHAR2(100),
    password VARCHAR2(100),
    created_at DATETIME,
    updated_at DATETIME
);
CREATE TABLE IF NOT EXISTS split (
    id NUMBER PRIMARY KEY auto_increment,
    type VARCHAR2(100),
    description VARCHAR2(150),
    created_at DATETIME,
    updated_at DATETIME
);