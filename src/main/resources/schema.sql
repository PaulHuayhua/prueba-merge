-- Primero eliminamos tablas hijas que referencian a otras
DROP TABLE IF EXISTS sale_detail;
DROP TABLE IF EXISTS buys_detail;

DROP TABLE IF EXISTS sale;
DROP TABLE IF EXISTS buys;

-- Ahora eliminamos las tablas de entidades “padre”
DROP TABLE IF EXISTS [user];
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS product;

-- --------------------------------------------------
-- A partir de aquí, las CREATE TABLE en el mismo orden
-- --------------------------------------------------

CREATE TABLE product (
    identifier INT NOT NULL IDENTITY(1,1),
    name VARCHAR(70) NOT NULL,
    description VARCHAR(60) NOT NULL,
    size VARCHAR(20) NULL,
    stock INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    expiration_date DATE NULL,
    category VARCHAR(100) NOT NULL,
    state bit  NOT NULL DEFAULT 1,
    CONSTRAINT uq_name_size_category UNIQUE (name, category, size, description),
    CONSTRAINT chk_stock_product CHECK (stock >= 0),
    CONSTRAINT chk_price_product CHECK (price >= 0),
    CONSTRAINT chk_name_product CHECK (name NOT LIKE '%[^a-zA-Z áéíóúÁÉÍÓÚñÑ]%'),
    CONSTRAINT pk_producto PRIMARY KEY (identifier)
);

CREATE TABLE supplier (
   identifier INT NOT NULL IDENTITY(1,1),
   name VARCHAR(80) NOT NULL,
   company VARCHAR(100) NOT NULL,
   supply_type VARCHAR(50) NOT NULL,
   address VARCHAR(150) NOT NULL,
   email_business VARCHAR(255) NOT NULL,
   cellular CHAR(9) NOT NULL,
   ruc CHAR(11) NOT NULL,
   registration_date DATE NOT NULL DEFAULT GETDATE(),
   state bit  NOT NULL DEFAULT 1,
   CONSTRAINT uq_name_ruc_supplier UNIQUE (name, ruc),
   CONSTRAINT chk_cellular CHECK (LEN(cellular) = 9 AND cellular LIKE '9%' AND cellular NOT LIKE '%[^0-9]%'),
   CONSTRAINT chk_ruc CHECK (LEN(ruc) = 11 AND ruc NOT LIKE '%[^0-9]%'),
   CONSTRAINT chk_email_business CHECK (email_business LIKE '_%@_%._%' AND LEN(email_business) <= 255 AND email_business NOT LIKE '% %'),
   CONSTRAINT chk_name_supplier CHECK (LEN(name) >= 3 AND name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
   CONSTRAINT proveedor_pk PRIMARY KEY (identifier)
);

CREATE TABLE customer (
    identifier INT NOT NULL IDENTITY(1,1),
    first_name VARCHAR(180) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    CONSTRAINT chk_first_name_customer CHECK (first_name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT chk_last_name_customer CHECK (last_name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT customer_pk PRIMARY KEY (identifier)
);

CREATE TABLE [user] (
    identifier INT NOT NULL IDENTITY(1,1),
    name VARCHAR(80) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    rol VARCHAR(60) NOT NULL,
    registration_date DATE NOT NULL DEFAULT GETDATE(),
    state CHAR(1) NOT NULL DEFAULT 'A',
    CONSTRAINT uq_email UNIQUE (email),
    CONSTRAINT chk_email CHECK (email LIKE '_%@_%._%' AND email NOT LIKE '% %'),
    CONSTRAINT chk_state_user CHECK (state IN ('A', 'I')),
    CONSTRAINT chk_name_user CHECK (LEN(name) >= 3 AND name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT chk_rol_user CHECK (rol IN ('Administrador', 'Empleado')),
    CONSTRAINT usuario_pk PRIMARY KEY (identifier)
);

CREATE TABLE sale (
    identifier INT NOT NULL IDENTITY(1,1),
    issue_date DATETIME NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    customer_identifier INT NOT NULL,
    user_identifier INT NOT NULL,
    CONSTRAINT chk_total_price_sale CHECK (total_price >= 0),
    CONSTRAINT venta_pk PRIMARY KEY (identifier)
);

CREATE TABLE sale_detail (
    identifier INT NOT NULL IDENTITY(1,1),
    amount INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    sale_identifier INT NOT NULL,
    product_identifier INT NOT NULL,
    CONSTRAINT chk_amount_sale CHECK (amount >= 0),
    CONSTRAINT chk_subtotal_sale CHECK (subtotal >= 0),
    CONSTRAINT detalle_venta_pk PRIMARY KEY (identifier)
);

CREATE TABLE buys (
    identifier INT NOT NULL IDENTITY(1,1),
    buys_date DATETIME NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    user_identifier INT NOT NULL,
    supplier_identifier INT NOT NULL,
    CONSTRAINT chk_total_price_buys CHECK (total_price >= 0),
    CONSTRAINT compra_pk PRIMARY KEY (identifier)
);

CREATE TABLE buys_detail (
   identifier INT NOT NULL IDENTITY(1,1),
   amount INT NOT NULL,
   unit_cost DECIMAL(10,2) NOT NULL,
   subtotal DECIMAL(10,2) NOT NULL,
   buys_identifier INT NOT NULL,
   product_identifier INT NOT NULL,
   CONSTRAINT chk_amount_buys CHECK (amount >= 0),
   CONSTRAINT chk_unit_cost CHECK (unit_cost >= 0),
   CONSTRAINT chk_subtotal_buys CHECK (subtotal = amount * unit_cost),
   CONSTRAINT detalle_compra_pk PRIMARY KEY (identifier)
);

-- Ahora redefinimos las FK sobre tablas ya creadas
ALTER TABLE sale_detail ADD CONSTRAINT sale_detail_product
    FOREIGN KEY (product_identifier)
    REFERENCES product (identifier)
    ON UPDATE CASCADE;

ALTER TABLE sale_detail ADD CONSTRAINT sale_detail_sale
    FOREIGN KEY (sale_identifier)
    REFERENCES sale (identifier)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE sale ADD CONSTRAINT sale_customer
    FOREIGN KEY (customer_identifier)
    REFERENCES customer (identifier)
    ON UPDATE CASCADE;

ALTER TABLE buys ADD CONSTRAINT buys_user
    FOREIGN KEY (user_identifier)
    REFERENCES [user] (identifier)
    ON UPDATE CASCADE;

ALTER TABLE buys ADD CONSTRAINT buys_supplier
    FOREIGN KEY (supplier_identifier)
    REFERENCES supplier (identifier)
    ON UPDATE CASCADE;

ALTER TABLE buys_detail ADD CONSTRAINT buys_detail_buys
    FOREIGN KEY (buys_identifier)
    REFERENCES buys (identifier)
    ON DELETE CASCADE
    ON UPDATE CASCADE;

ALTER TABLE buys_detail ADD CONSTRAINT buys_detail_product
    FOREIGN KEY (product_identifier)
    REFERENCES product (identifier)
    ON UPDATE CASCADE;
