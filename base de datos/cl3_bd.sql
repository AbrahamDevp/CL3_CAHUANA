CREATE DATABASE IF NOT EXISTS cl3_cahuana;
USE cl3_cahuana;

CREATE TABLE IF NOT EXISTS Producto(
    id int NOT NULL AUTO_INCREMENT COMMENT 'Id del Producto',
    nombre_producto varchar(100) NOT NULL COMMENT 'Nombre del Producto',
    descripcion_producto varchar(100) NOT NULL COMMENT 'Descripción del Producto',
    fecha_registro date NOT NULL COMMENT 'Fecha de Registro',
    PRIMARY KEY (id)
);

INSERT INTO Producto (nombre_producto, descripcion_producto, fecha_registro)
VALUES ('Paneton', 'Descripción del producto 1', '2023-06-22');

INSERT INTO Producto (nombre_producto, descripcion_producto, fecha_registro)
VALUES ('Platano', 'Descripción del producto 2', '2023-06-22');

INSERT INTO Producto (nombre_producto, descripcion_producto, fecha_registro)
VALUES ('Coca Cola', 'Descripción del producto 3', '2023-06-22');

select * from Producto