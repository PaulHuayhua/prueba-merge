INSERT INTO category (name) VALUES
('Bebidas'),
('Abarrotes'),
('Lácteos');

INSERT INTO product (name, type, flavor, size, stock, price, expiration_date, state, category_identifier) VALUES
('Coca Cola', 'Refresco', 'Original', '500ml', 100, 2.50, '2025-12-31', 'A', 1),
('Galletas Oreo', 'Galleta', 'Chocolate', '200g', 50, 3.00, '2026-01-01', 'A', 2),
('Leche Alpura', 'Lácteo', 'Entera', '1L', 30, 1.50, '2025-11-30', 'A', 3);


INSERT INTO supplier (name, company, supply_type, address, email_business, cellular, ruc, state)
VALUES 
('Pedro Sánchez', 'Distribuidora Andina', 'Bebidas', 'Av. Perú 123', 'contacto@andina.com', '912345678', '20123456789', 'A'),
('María Huamán', 'SnackExpress', 'Snacks', 'Calle Los Olivos 456', 'ventas@snackexpress.com', '987654321', '20456789123', 'A');

