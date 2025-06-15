-- Inserción en product, supplier, customer y user (ya los tienes, los repito)
INSERT INTO product (name, description, size, stock, price, expiration_date, category)
VALUES
('Arroz', 'Del Campo', '50kg', 50, 4.20, '2025-12-31', 'Abarrotes'),
('Coca Cola', 'Sabor original', '500ml', 100, 1.50, '2025-08-10', 'Bebidas'),
('Coca Cola', 'Sabor zero azúcar', '1l', 80, 1.60, '2025-08-10', 'Bebidas');

INSERT INTO supplier (company, supply_type, address, email_business, cell_phone, ruc)
VALUES 
('Distribuidora Andina', 'Bebidas', 'Av. Perú 123', 'contacto@andina.com', '912345678', '20123456789'),
('SnackExpress', 'Snacks', 'Calle Los Olivos 456', 'ventas@snackexpress.com', '987654321', '20456789123'),
('Frutas del Valle', 'Frutas', 'Jr. Amazonas 789', 'luis@frutasvalle.com', '923456789', '20567891234');

INSERT INTO customer (first_name, last_name) 
VALUES
('Carlos', 'Ramírez'),
('Ana María', 'González'),
('José', 'Pérez'),
('Lucía', 'Delgado'),
('Miguel Ángel', 'Zapata');

INSERT INTO [user] (name, email, password_hash, rol)
VALUES
('Juan Pérez', 'juan.perez@mail.com', 'password123', 'Administrador'),
('Ana Gómez', 'ana.gomez@mail.com', 'password456', 'Empleado'),
('Carlos Ruiz', 'carlos.ruiz@mail.com', 'password789', 'Empleado');

-- Inserción en sale (ventas)
INSERT INTO sale (issue_date, total_price, customer_identifier, user_identifier)
VALUES
('2025-05-20 10:30:00', 12.30, 1, 1),   -- venta para Carlos Ramírez por Juan Pérez
('2025-05-21 14:45:00', 3.20, 2, 2);    -- venta para Ana María González por Ana Gómez

-- Inserción en sale_detail (detalle de ventas)
INSERT INTO sale_detail (amount, subtotal, sale_identifier, product_identifier)
VALUES
(2, 8.40, 1, 1),  -- 2 unidades Arroz para la venta 1
(3, 3.90, 1, 2),  -- 3 unidades Coca Cola 500ml para la venta 1
(2, 3.20, 2, 2);  -- 2 unidades Coca Cola 500ml para la venta 2

-- Inserción en buys (compras)
INSERT INTO buys (total_price, payment_method, user_identifier, supplier_identifier)
VALUES
(100.00, 'Efectivo', 3, 1),  -- compra por Carlos Ruiz a Pedro Sánchez
(50.00, 'Efectivo', 1, 2);   -- compra por Juan Pérez a María Huamán

-- Inserción en buys_detail (detalle de compras)
INSERT INTO buys_detail (amount, unit_cost, subtotal, buys_identifier, product_identifier)
VALUES
(50, 1.50, 75.00, 1, 2),  -- 50 unidades Coca Cola 500ml para compra 1
(20, 1.25, 25.00, 2, 3);  -- 20 unidades Coca Cola 1l para compra 2
