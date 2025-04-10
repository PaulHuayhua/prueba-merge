-- Crear la tabla
CREATE TABLE supplier (
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    company VARCHAR(100) NOT NULL,
    cellular CHAR(9) NOT NULL,
    state CHAR(1) NOT NULL
);
