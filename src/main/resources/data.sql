-- Crear el registro si es que no se duplican datos unicos o se insertan datos nulos
INSERT INTO supplier (name, company, supply_type, address, email_business, cellular, ruc, state)
VALUES 
('Pedro Sánchez', 'Distribuidora Andina', 'Bebidas', 'Av. Perú 123', 'contacto@andina.com', '912345678', '20123456789', 'A'),
('María Huamán', 'SnackExpress', 'Snacks', 'Calle Los Olivos 456', 'ventas@snackexpress.com', '987654321', '20456789123', 'A');

