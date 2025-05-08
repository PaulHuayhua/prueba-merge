CREATE TABLE product (
    identifier INT NOT NULL IDENTITY(1,1),  -- Identificador autoincrementable
    name VARCHAR(70) NOT NULL,
    type VARCHAR(50) NOT NULL,
    flavor VARCHAR(60) NOT NULL,
    size VARCHAR(20) NOT NULL,
    stock INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,  -- Cambié el tipo de dato para permitir dos decimales
    expiration_date DATETIME NOT NULL,
    state CHAR(1) NOT NULL,  -- Estado, por ejemplo 'A' para activo
    category VARCHAR(20) NOT NULL,
    PRIMARY KEY (identifier)
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