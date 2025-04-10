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
