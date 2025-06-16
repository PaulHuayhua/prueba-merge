-- ========== TABLA: user ==========
INSERT INTO [user] (name, email, password_hash, rol)
VALUES
('Juan Pérez', 'juan.perez@empresa.com', 'hash1', 'Administrador'),
('Lucía Gómez', 'lucia.gomez@empresa.com', 'hash2', 'Empleado'),
('Carlos Ruiz', 'carlos.ruiz@empresa.com', 'hash3', 'Empleado'),
('Ana Torres', 'ana.torres@empresa.com', 'hash4', 'Administrador'),
('Luis Vega', 'luis.vega@empresa.com', 'hash5', 'Empleado');

-- ========== TABLA: supplier ==========
INSERT INTO supplier (company, supply_type, address, email_business, cell_phone, ruc)
VALUES
('Distribuidora ABC', 'Alimentos', 'Av. Perú 123', 'contacto@abc.com', '987654321', '10458965231'),
('Insumos XYZ', 'Bebidas', 'Jr. Lima 456', 'ventas@xyz.com', '987654322', '20458965232'),
('Farmacia Vida', 'Medicamentos', 'Calle Salud 789', 'contacto@vida.com', '987654323', '30458965233'),
('Electro Perú', 'Electrodomesticos', 'Av. Tecnológica 321', 'info@electro.com', '987654324', '40458965234'),
('Textiles Andinos', 'Ropa', 'Jr. Cusco 654', 'ventas@andinos.com', '987654325', '50458965235');

-- ========== TABLA: customer ==========
INSERT INTO customer (first_name, last_name)
VALUES
('María', 'Fernández'),
('Pedro', 'Ramírez'),
('Sofía', 'López'),
('Diego', 'Martínez'),
('Camila', 'García');

-- ========== TABLA: product ==========
INSERT INTO product (name, description, size, stock, price, expiration_date, category)
VALUES
('Leche Gloria', 'Leche evaporada', '400ml', 100, 4.50, '2025-12-31', 'Lácteos'),
('Arroz Costeño', 'Arroz superior', '1kg', 200, 3.20, NULL, 'Granos'),
('Aceite Primor', 'Aceite vegetal', '1L', 150, 7.00, '2026-01-15', 'Aceites'),
('Jabón Bolívar', 'Jabón en barra', '200g', 80, 2.50, NULL, 'Limpieza'),
('Gaseosa Inka Kola', 'Botella personal', '500ml', 90, 2.80, '2025-11-10', 'Bebidas');

-- ========== TABLA: purchase ==========
INSERT INTO purchase (purchase_date, total_price, payment_method, user_identifier, supplier_identifier)
VALUES
(GETDATE(), 200.00, 'Efectivo', 1, 1),
(GETDATE(), 350.00, 'Transferencia', 2, 2),
(GETDATE(), 500.00, 'Tarjeta', 3, 3),
(GETDATE(), 180.00, 'Efectivo', 4, 4),
(GETDATE(), 220.00, 'Yape', 5, 5);

-- ========== TABLA: purchase_detail ==========
INSERT INTO purchase_detail (amount, unit_cost, subtotal, product_identifier, purchase_identifier)
VALUES
(10, 4.50, 45.00, 1, 1),
(20, 3.20, 64.00, 2, 2),
(15, 7.00, 105.00, 3, 3),
(30, 2.50, 75.00, 4, 4),
(25, 2.80, 70.00, 5, 5);

-- ========== TABLA: sale ==========
INSERT INTO sale (issue_date, total_price, payment_method, customer_identifier, user_identifier)
VALUES
(GETDATE(), 60.00, 'Yape', 1, 1),
(GETDATE(), 120.00, 'Efectivo', 2, 2),
(GETDATE(), 90.00, 'Transferencia', 3, 3),
(GETDATE(), 140.00, 'Tarjeta', 4, 4),
(GETDATE(), 85.00, 'Efectivo', 5, 5);

-- ========== TABLA: sale_detail ==========
INSERT INTO sale_detail (amount, subtotal, sale_identifier, product_identifier)
VALUES
(3, 13.50, 1, 1),
(10, 32.00, 2, 2),
(5, 35.00, 3, 3),
(4, 10.00, 4, 4),
(6, 16.80, 5, 5);
