-- Primero elimina las tablas más dependientes
DROP TABLE IF EXISTS purchase_detail;
DROP TABLE IF EXISTS sale_detail;
DROP TABLE IF EXISTS purchase
DROP TABLE IF EXISTS sale;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS [user];

CREATE TABLE customer (
    identifier int  NOT NULL IDENTITY(1, 1),
    first_name varchar(180)  NOT NULL,
    last_name varchar(250)  NOT NULL,
    CONSTRAINT chk_first_name_customer CHECK (first_name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT chk_last_name_customer CHECK (last_name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT customer_pk PRIMARY KEY  (identifier)
);

-- Table: product
CREATE TABLE product (
    identifier int  NOT NULL IDENTITY(1, 1),
    name varchar(70)  NOT NULL,
    description varchar(160)  NOT NULL,
    size varchar(20)  NULL,
    stock int  NOT NULL,
    price decimal(10,2)  NOT NULL,
    expiration_date date  NULL,
    category varchar(100)  NOT NULL,
    state bit  NOT NULL DEFAULT 1,
    CONSTRAINT uq_name_size_category UNIQUE (name, category, size, description),
    CONSTRAINT chk_stock_product CHECK (stock >= 0),
    CONSTRAINT chk_price_product CHECK (price >= 0),
    CONSTRAINT chk_name_product CHECK (name NOT LIKE '%[^a-zA-Z áéíóúÁÉÍÓÚñÑ]%'),
    CONSTRAINT pk_producto PRIMARY KEY  (identifier)
);

-- Table: purchase
CREATE TABLE purchase (
    identifier int  NOT NULL IDENTITY(1, 1),
    purchase_date datetime  NOT NULL,
    total_price decimal(10,2)  NOT NULL,
    payment_method varchar(20)  NOT NULL,
    user_identifier int  NOT NULL,
    supplier_identifier int  NOT NULL,
    CONSTRAINT chk_total_price_purchase CHECK (total_price >= 0),
    CONSTRAINT chk_payment_method_purchase CHECK (payment_method NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT compra_pk PRIMARY KEY  (identifier)
);

-- Table: purchase_detail
CREATE TABLE purchase_detail (
    identifier int  NOT NULL IDENTITY(1, 1),
    amount int  NOT NULL,
    unit_cost decimal(10,2)  NOT NULL,
    subtotal decimal(10,2)  NOT NULL,
    product_identifier int  NOT NULL,
    purchase_identifier int  NOT NULL,
    CONSTRAINT chk_amount_purchase CHECK (amount >= 0),
    CONSTRAINT chk_unit_cost CHECK (unit_cost >= 0),
    CONSTRAINT chk_subtotal_purchase CHECK (subtotal = amount * unit_cost),
    CONSTRAINT detalle_compra_pk PRIMARY KEY  (identifier)
);

-- Table: sale
CREATE TABLE sale (
    identifier int  NOT NULL IDENTITY(1, 1),
    issue_date datetime  NOT NULL,
    total_price decimal(10,2)  NOT NULL,
    payment_method varchar(20)  NOT NULL,
    customer_identifier int  NOT NULL,
    user_identifier int  NOT NULL,
    CONSTRAINT chk_total_price_sale CHECK (total_price >= 0),
    CONSTRAINT chk_payment_method_sale CHECK (payment_method NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT venta_pk PRIMARY KEY  (identifier)
);

-- Table: sale_detail
CREATE TABLE sale_detail (
    identifier int  NOT NULL IDENTITY(1, 1),
    amount int  NOT NULL,
    subtotal decimal(10,2)  NOT NULL,
    sale_identifier int  NOT NULL,
    product_identifier int  NOT NULL,
    CONSTRAINT chk_amount_sale CHECK (amount >= 0),
    CONSTRAINT chk_subtotal_sale CHECK (subtotal >= 0),
    CONSTRAINT detalle_venta_pk PRIMARY KEY  (identifier)
);

-- Table: supplier
CREATE TABLE supplier (
    identifier int  NOT NULL IDENTITY(1, 1),
    company varchar(100)  NOT NULL,
    supply_type varchar(50)  NOT NULL,
    address varchar(150)  NOT NULL,
    email_business varchar(255)  NOT NULL,
    cell_phone char(9)  NOT NULL,
    ruc char(11)  NOT NULL,
    registration_date date  NOT NULL DEFAULT GETDATE(),
    state bit  NOT NULL DEFAULT 1,
    CONSTRAINT uq_ruc_supplier UNIQUE (ruc),
    CONSTRAINT chk_cell_phone CHECK (LEN(cell_phone) = 9 AND  cell_phone LIKE '9%' AND  cell_phone NOT LIKE '%[^0-9]%'),
    CONSTRAINT chk_ruc CHECK (LEN(ruc) = 11 AND ruc NOT LIKE '%[^0-9]%'),
    CONSTRAINT chk_email_business CHECK (email_business LIKE '_%@_%._%' AND LEN(email_business) <= 255 AND email_business NOT LIKE '% %'),
    CONSTRAINT proveedor_pk PRIMARY KEY  (identifier)
);

-- Table: user
CREATE TABLE [user] (
    identifier int  NOT NULL IDENTITY(1, 1),
    name varchar(80)  NOT NULL,
    email varchar(255)  NOT NULL,
    password_hash varchar(255)  NOT NULL,
    rol varchar(60)  NOT NULL,
    registration_date date  NOT NULL DEFAULT GETDATE(),
    state bit  NOT NULL DEFAULT 1,
    CONSTRAINT uq_email UNIQUE (email),
    CONSTRAINT chk_email CHECK (email LIKE '_%@_%._%' AND email NOT LIKE '% %'),
    CONSTRAINT chk_state_user CHECK (state IN (0, 1)),
    CONSTRAINT chk_name_user CHECK (LEN(name) >= 3 AND name NOT LIKE '%[^a-zA-ZáéíóúÁÉÍÓÚ ]%'),
    CONSTRAINT chk_rol_user CHECK (rol IN ('Administrador', 'Empleado')),
    CONSTRAINT usuario_pk PRIMARY KEY  (identifier)
);

-- foreign keys
-- Reference: purchase_detail_product (table: purchase_detail)
ALTER TABLE purchase_detail ADD CONSTRAINT purchase_detail_product
    FOREIGN KEY (product_identifier)
    REFERENCES product (identifier)
    ON UPDATE  CASCADE;

-- Reference: purchase_detail_purchase (table: purchase_detail)
ALTER TABLE purchase_detail ADD CONSTRAINT purchase_detail_purchase
    FOREIGN KEY (purchase_identifier)
    REFERENCES purchase (identifier);

-- Reference: purchase_supplier (table: purchase)
ALTER TABLE purchase ADD CONSTRAINT purchase_supplier
    FOREIGN KEY (supplier_identifier)
    REFERENCES supplier (identifier)
    ON UPDATE  CASCADE;

-- Reference: purchase_user (table: purchase)
ALTER TABLE purchase ADD CONSTRAINT purchase_user
    FOREIGN KEY (user_identifier)
    REFERENCES "user" (identifier)
    ON UPDATE  CASCADE;

-- Reference: sale_customer (table: sale)
ALTER TABLE sale ADD CONSTRAINT sale_customer
    FOREIGN KEY (customer_identifier)
    REFERENCES customer (identifier)
    ON UPDATE  CASCADE;

-- Reference: sale_detail_product (table: sale_detail)
ALTER TABLE sale_detail ADD CONSTRAINT sale_detail_product
    FOREIGN KEY (product_identifier)
    REFERENCES product (identifier)
    ON UPDATE  CASCADE;

-- Reference: sale_detail_sale (table: sale_detail)
ALTER TABLE sale_detail ADD CONSTRAINT sale_detail_sale
    FOREIGN KEY (sale_identifier)
    REFERENCES sale (identifier)
    ON DELETE  CASCADE 
    ON UPDATE  CASCADE;

-- Reference: sale_user (table: sale)
ALTER TABLE sale ADD CONSTRAINT sale_user
    FOREIGN KEY (user_identifier)
    REFERENCES "user" (identifier)
    ON UPDATE  CASCADE;

-- End of file.
