-- Crear el registro si es que no se duplican datos unicos o se insertan datos nulos
INSERT INTO product (name, type, flavor, size, stock, price, expiration_date, state, category)
VALUES
('Coca Cola', '-', 'Cola', '1L', 150, 3.50, '2025-12-31 00:00:00', 'A', 'Bebida'),
('KR', '-', 'Fresa', '1L', 200, 2.00, '2025-11-30 00:00:00', 'A', 'Bebida'),
('Yogurt', 'Natural', '-', '1L', 100, 1.80, '2025-10-15 00:00:00', 'A', 'Lácteo'),
('Leche Gloria', 'Entera', '-', '1L', 250, 3.00, '2025-09-01 00:00:00', 'A', 'Lácteo'),
('Atún Florida', '-', '-', '170g', 120, 5.00, '2025-10-05 00:00:00', 'A', 'Conserva');

INSERT INTO supplier (name, company, supply_type, address, email_business, cellular, ruc, state)
VALUES 
('Pedro Sánchez', 'Distribuidora Andina', 'Bebidas', 'Av. Perú 123', 'contacto@andina.com', '912345678', '20123456789', 'A'),
('María Huamán', 'SnackExpress', 'Snacks', 'Calle Los Olivos 456', 'ventas@snackexpress.com', '987654321', '20456789123', 'A');

