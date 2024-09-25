CREATE TABLE IF NOT EXISTS split (
    id NUMBER PRIMARY KEY auto_increment,
    "type" VARCHAR2(100) NOT NULL,
    "description" VARCHAR2(150) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME
);
CREATE TABLE IF NOT EXISTS users (
    id NUMBER PRIMARY KEY auto_increment,
    "name" VARCHAR2(100) NOT NULL,
    gym VARCHAR2(100),
    email VARCHAR2(100) NOT NULL,
    password VARCHAR2(100) NOT NULL,
    split VARCHAR2(100) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME,
    CONSTRAINT fk_user_split FOREIGN KEY (split) REFERENCES split(id)
);
