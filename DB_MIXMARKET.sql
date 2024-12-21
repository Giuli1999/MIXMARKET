use sys;
SET GLOBAL log_bin_trust_function_creators = 1;

DROP database IF EXISTS MIXMARKET;
CREATE DATABASE MIXMARKET;

USE MIXMARKET;

-- tables
-- Table: BOLETA
CREATE TABLE BOLETA (
    ID int  NOT NULL auto_increment COMMENT 'identificador de la boleta',
    NUMBER_TICKET int  NOT NULL COMMENT 'numero de la boleta',
    DOCUMENTO_VENTA_ID int  NOT NULL,
    CONSTRAINT BOLETA_pk PRIMARY KEY (ID)
) COMMENT 'datos de la boleta';


-- Table: CAJERO
CREATE TABLE CAJERO (
    ID int  NOT NULL auto_increment COMMENT 'identificador del cajero',
    NAME_CASHIER varchar(45)  NOT NULL COMMENT 'nombre del cajero',
    NUMBER_BOX int  NOT NULL COMMENT 'numero de caja',
    CONSTRAINT CAJERO_pk PRIMARY KEY (ID)
) COMMENT 'datos del cajero';

-- Table: CLIENTE
CREATE TABLE CLIENTE (
    ID int  NOT NULL auto_increment COMMENT 'identificador del cliente',
    NAME_CUSTOMER varchar(45)  NOT NULL COMMENT 'nombre del cliente',
    LAST_NAME varchar(45)  NOT NULL COMMENT 'apellido del cliente',
    CONSTRAINT CLIENTE_pk PRIMARY KEY (ID)
) COMMENT 'datos del cliente';

-- Table: DOCUMENTO_VENTA
CREATE TABLE DOCUMENTO_VENTA (
    ID int  NOT NULL auto_increment COMMENT 'identificador del documento de venta',
    AMOUNT double(10,2)  NOT NULL COMMENT 'monto del documento de venta',
    TIME timestamp  NOT NULL COMMENT 'fecha de emisión',
    TYPE char(1) not null,
    CONSTRAINT DOCUMENTO_VENTA_pk PRIMARY KEY (ID)
) COMMENT 'datos principales del documento';

-- Table: FACTURA
CREATE TABLE FACTURA (
    ID int  NOT NULL auto_increment COMMENT 'identificador de la factura',
    SERIE int  NOT NULL COMMENT 'serie de la factura',
    DOCUMENTO_VENTA_ID int  NOT NULL,
    CONSTRAINT FACTURA_pk PRIMARY KEY (ID)
) COMMENT 'datos de la factura';


-- Table: PEDIDO
CREATE TABLE PEDIDO (
    ID int  NOT NULL auto_increment COMMENT 'Identificador del pedido',
    AMOUNT int  NOT NULL COMMENT 'cantidad ',
    TIME timestamp  NOT NULL,
    TRABAJADOR_ID int  NOT NULL,
    PROVEEDOR_ID int  NOT NULL,
    PRODUCTO_ID int  NOT NULL,
    CONSTRAINT PEDIDO_pk PRIMARY KEY (ID)
) COMMENT 'registro de los pedidos';

-- Table: PRODUCTO
CREATE TABLE PRODUCTO (
    ID int  NOT NULL auto_increment COMMENT 'identificador del producto',
    NAME_PRODUC varchar(45)  NOT NULL COMMENT 'nombre del producto',
    PRICE double(10,2)  NOT NULL COMMENT 'precio del producto',
    AMOUNT int  NOT NULL COMMENT 'cantidad del producto',
    CONSTRAINT PRODUCTO_pk PRIMARY KEY (ID)
) COMMENT 'datos de los productos';

-- Table: PROVEEDOR
CREATE TABLE PROVEEDOR (
    ID int  NOT NULL auto_increment COMMENT 'identificador del proveedor',
    RUC_E int  NOT NULL COMMENT 'RUC del proveedor',
    NAME_COMPANY varchar(45)  NOT NULL COMMENT 'nombre de la compañía',
    CONSTRAINT PROVEEDOR_pk PRIMARY KEY (ID)
) COMMENT 'registro de los proveedores';

-- Table: TRABAJADOR
CREATE TABLE TRABAJADOR (
    ID int  NOT NULL auto_increment COMMENT 'identificador del trabajador ',
    NAME varchar(45)  NOT NULL COMMENT 'nombre del trabajador',
    LAST_NAME varchar(45)  NOT NULL COMMENT 'apellido del trabajador',
    CONSTRAINT TRABAJADOR_pk PRIMARY KEY (ID)
) COMMENT 'datos del trabajador';

-- Table: VENTA
CREATE TABLE VENTA (
    ID int  NOT NULL auto_increment COMMENT 'identificador de la venta',
    AMOUNT_PRODUC int  NOT NULL,
    TIME timestamp  NOT NULL COMMENT 'fecha de la venta',
    CLIENTE_ID int  NOT NULL,
    CAJERO_ID int  NOT NULL,
    PRODUCTO_ID int  NOT NULL,
    DOCUMENTO_VENTA_ID int  NOT NULL,
    CONSTRAINT VENTA_pk PRIMARY KEY (ID)
) COMMENT 'registro de las ventas';

-- foreign keys
-- Reference: BOLETA_DOCUMENTO_VENTA (table: BOLETA)
ALTER TABLE BOLETA ADD CONSTRAINT BOLETA_DOCUMENTO_VENTA FOREIGN KEY BOLETA_DOCUMENTO_VENTA (DOCUMENTO_VENTA_ID)
    REFERENCES DOCUMENTO_VENTA (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: FACTURA_DOCUMENTO_VENTA (table: FACTURA)
ALTER TABLE FACTURA ADD CONSTRAINT FACTURA_DOCUMENTO_VENTA FOREIGN KEY FACTURA_DOCUMENTO_VENTA (DOCUMENTO_VENTA_ID)
    REFERENCES DOCUMENTO_VENTA (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: PEDIDO_PRODUCTO (table: PEDIDO)
ALTER TABLE PEDIDO ADD CONSTRAINT PEDIDO_PRODUCTO FOREIGN KEY PEDIDO_PRODUCTO (PRODUCTO_ID)
    REFERENCES PRODUCTO (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: PEDIDO_PROVEEDOR (table: PEDIDO)
ALTER TABLE PEDIDO ADD CONSTRAINT PEDIDO_PROVEEDOR FOREIGN KEY PEDIDO_PROVEEDOR (PROVEEDOR_ID)
    REFERENCES PROVEEDOR (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: PEDIDO_TRABAJADOR (table: PEDIDO)
ALTER TABLE PEDIDO ADD CONSTRAINT PEDIDO_TRABAJADOR FOREIGN KEY PEDIDO_TRABAJADOR (TRABAJADOR_ID)
    REFERENCES TRABAJADOR (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: VENTA_CAJERO (table: VENTA)
ALTER TABLE VENTA ADD CONSTRAINT VENTA_CAJERO FOREIGN KEY VENTA_CAJERO (CAJERO_ID)
    REFERENCES CAJERO (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: VENTA_CLIENTE (table: VENTA)
ALTER TABLE VENTA ADD CONSTRAINT VENTA_CLIENTE FOREIGN KEY VENTA_CLIENTE (CLIENTE_ID)
    REFERENCES CLIENTE (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: VENTA_DOCUMENTO_VENTA (table: VENTA)
ALTER TABLE VENTA ADD CONSTRAINT VENTA_DOCUMENTO_VENTA FOREIGN KEY VENTA_DOCUMENTO_VENTA (DOCUMENTO_VENTA_ID)
    REFERENCES DOCUMENTO_VENTA (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- Reference: VENTA_PRODUCTO (table: VENTA)
ALTER TABLE VENTA ADD CONSTRAINT VENTA_PRODUCTO FOREIGN KEY VENTA_PRODUCTO (PRODUCTO_ID)
    REFERENCES PRODUCTO (ID) ON DELETE CASCADE ON UPDATE CASCADE;

-- End of file.
insert into CLIENTE ( NAME_CUSTOMER, LAST_NAME)
values ('Cristopher', 'sotelo'),
('	Ronald', 'Espinoza');
select*from CLIENTE;
insert into CAJERO ( NAME_CASHIER, NUMBER_BOX)
VALUES( 'Paola', '3'),
      ( 'Jorge', '2');
select*from CAJERO;
insert into PRODUCTO ( NAME_PRODUC, PRICE, AMOUNT)
VALUES( 'fideo', 5.4, '20'),
      ('leche', 4.2, '15');
select*from PRODUCTO;
update PRODUCTO set NAME_PRODUC='PAN', PRICE=8.0, AMOUNT= '21' WHERE ID=1 ;
insert into TRABAJADOR ( NAME, LAST_NAME)
values ( 'Rosa', 'Linares'),
( 'Pedro', 'Yactayo');
select*from TRABAJADOR;
insert into PROVEEDOR ( RUC_E, NAME_COMPANY)
values ( '2015678954', 'ARCOR'),
('	2046379345', 'Nestle');
select*from PROVEEDOR;
insert into PEDIDO ( AMOUNT, TIME, TRABAJADOR_ID, PROVEEDOR_ID, PRODUCTO_ID)
values ('22', '2024-11-08 10:00:00', '0001', '00001',0002),
       ( '13','2024-11-08 11:35:06', '0002', '00002',0001);
select*from PEDIDO;


insert into DOCUMENTO_VENTA ( AMOUNT, TIME, TYPE)
values ( '11', '2024-11-07 09:12:36', 'B'),
       ( '8','2024-11-07 10:34:29','F'),
       ( '20', '2024-11-07 11:12:36', 'B'),
       ( '18','2024-11-07 12:34:29','F');
select*from DOCUMENTO_VENTA;
insert into VENTA ( AMOUNT_PRODUC, TIME, CLIENTE_ID, CAJERO_ID, PRODUCTO_ID, DOCUMENTO_VENTA_ID)
values ( '2', '2024-11-07 09:16:06', '2', '01', '002', '02'),
       ( '3','2024-11-07 10:40:19', '1', '02', '001', '01');
select*from VENTA;
insert into BOLETA ( NUMBER_TICKET, DOCUMENTO_VENTA_ID)
values ( '645', '2'),
       ( '3', '1');
select*from BOLETA;
insert into BOLETA ( NUMBER_TICKET, DOCUMENTO_VENTA_ID)
values        ( '5', '11');
select*from BOLETA;
insert into FACTURA ( SERIE, DOCUMENTO_VENTA_ID)
values ('2468', '2'),
       ( '3742', '1');
select*from FACTURA;

CREATE OR REPLACE VIEW VENTA_BOLETA AS 
SELECT 
    Documento_Venta.ID AS ID_Documento_Venta, 
    Documento_Venta.Amount, 
    Documento_Venta.Time,  
    CASE 
        WHEN Documento_Venta.TYPE = 'B' THEN 'BOLETA' 
        WHEN Documento_Venta.TYPE = 'F' THEN 'FACTURA' 
        ELSE 'OTRO'
    END AS Tipo_Documento,
    COALESCE(Boleta.ID, Factura.ID) AS ID_Documento_Adicional,
    COALESCE(Boleta.Number_ticket, Factura.serie) AS Numero_Documento_Adicional
FROM Documento_Venta 
LEFT JOIN Boleta ON Documento_Venta.ID = Boleta.Documento_Venta_ID 
LEFT JOIN Factura ON Documento_Venta.ID = Factura.DOCUMENTO_VENTA_ID;

CREATE OR REPLACE VIEW PEDIDO_FULL AS
SELECT Pedido.ID, Pedido.AMOUNT, Pedido.TIME, Trabajador.ID AS TRABAJADOR_ID,
concat(Trabajador.NAME, ' ',Trabajador.LAST_NAME) as NOMBRE_TRABAJADOR, 
Proveedor.ID AS PROVEEDOR_ID, Proveedor.NAME_COMPANY,
Producto.ID AS PRODUCTO_ID, Producto.NAME_PRODUC
FROM Pedido
INNER JOIN Trabajador on Pedido.Trabajador_ID = Trabajador.ID
INNER JOIN Proveedor on Pedido.Proveedor_ID = Proveedor.ID
INNER JOIN Producto on Pedido.Producto_ID = Producto.ID;
SELECT*FROM PEDIDO_FULL;
select ID_Documento_Venta, Amount, Time, Tipo_Documento, ID_Documento_Adicional, Numero_Documento_Adicional from VENTA_BOLETA;

SELECT ID, CONCAT(NAME, ' ', LAST_NAME) AS NOMBRE
FROM TRABAJADOR;
SELECT ID, NAME_COMPANY FROM PROVEEDOR;
select ID, NAME_PRODUC FROM PRODUCTO;
CREATE OR REPLACE VIEW VENTA_FULL AS
SELECT Venta.ID, Venta.AMOUNT_PRODUC, Venta.TIME,
 cliente.ID AS CLIENTE_ID, 
concat(Cliente.NAME_CUSTOMER, ' ',Cliente.LAST_NAME) as NOMBRE_CLIENTE, 
Cajero.ID as CAJERO_ID, Cajero.NAME_CASHIER as NOMBRE_CAJERO, 
Producto.ID as PRODUCTO_ID, Producto.NAME_PRODUC, 
DOCUMENTO_VENTA.ID AS DOCUMENTO_VENTA_ID
FROM Venta
INNER JOIN Cliente on Venta.Cliente_ID = Cliente.ID
INNER JOIN Cajero on Venta.Cajero_ID = Cajero.ID
INNER JOIN Producto on Venta.Producto_ID = Producto.ID
INNER JOIN Documento_Venta on Venta.Documento_Venta_ID = Documento_Venta.ID;
SELECT*FROM VENTA_FULL;


