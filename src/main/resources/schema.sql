-- Table: product
CREATE TABLE product (
    identifier int  NOT NULL IDENTITY(1, 1),
    name varchar(70)  NOT NULL,
    type varchar(50)  NULL,
    flavor varchar(60)  NULL,
    size varchar(20)  NULL,
    stock int  NOT NULL,
    price decimal(10,2)  NOT NULL,
    expiration_date date  NULL,
    state char(1)  NOT NULL DEFAULT 'A',
    category_identifier int  NOT NULL,
    CONSTRAINT chk_stock CHECK (stock >= 0),
    CONSTRAINT chk_price CHECK (price >= 0),
    CONSTRAINT chk_status CHECK (state IN ('A', 'I')),
    CONSTRAINT pk_producto PRIMARY KEY  (identifier)
);

-- Table: category
CREATE TABLE category (
    identifier int  NOT NULL IDENTITY(1, 1),
    name varchar(80)  NOT NULL,
    CONSTRAINT uq_category_name UNIQUE (name),
    CONSTRAINT category_pk PRIMARY KEY  (identifier)
);

-- Crear la tabla
CREATE TABLE supplier (
    identifier INT  NOT NULL IDENTITY(1, 1),
    name VARCHAR(80)  NOT NULL,
    company VARCHAR(100)  NOT NULL,
    supply_type VARCHAR(50)  NOT NULL,
    address VARCHAR(150)  NOT NULL,
    email_business VARCHAR(255)  NOT NULL,
    cellular CHAR(9)  NOT NULL,
    ruc CHAR(11)  NOT NULL,
    state CHAR(1)  NOT NULL DEFAULT 'A',
    CONSTRAINT chk_cellular CHECK (LEN(cellular) = 9 AND  cellular LIKE '9%' AND  cellular NOT LIKE '%[^0-9]%'),
    CONSTRAINT chk_ruc CHECK (LEN(ruc) = 11 AND ruc NOT LIKE '%[^0-9]%'),
    CONSTRAINT chk_email_business CHECK (email_business LIKE '_%@_%._%' AND LEN(email_business) <= 255 AND email_business NOT LIKE '% %'),
    CONSTRAINT chk_name_supplier CHECK (LEN(name) >= 3 AND name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT chk_state_supplier CHECK (state IN ('A', 'I')),
    CONSTRAINT pk_supplier PRIMARY KEY  (identifier)
);