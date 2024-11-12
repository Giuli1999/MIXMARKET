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
insert into DOCUMENTO_VENTA ( AMOUNT, TIME)
values ( '11', '2024-11-07 09:12:36'),
       ( '8','2024-11-07 10:34:29');
select*from DOCUMENTO_VENTA;
insert into VENTA ( AMOUNT_PRODUC, TIME, CLIENTE_ID, CAJERO_ID, PRODUCTO_ID, DOCUMENTO_VENTA_ID)
values ( '2', '2024-11-07 09:16:06', '2', '01', '002', '02'),
       ( '3','2024-11-07 10:40:19', '1', '02', '001', '01');
select*from VENTA;
insert into BOLETA ( NUMBER_TICKET, DOCUMENTO_VENTA_ID)
values ( '2', '02'),
       ( '3', '01');
select*from BOLETA;
insert into FACTURA ( SERIE, DOCUMENTO_VENTA_ID)
values ('2468', '02'),
       ( '3742', '01');
select*from FACTURA;