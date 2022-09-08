CREATE TABLE cambio (
    id SERIAL NOT NULL PRIMARY KEY,
    from_currency CHAR(3) NOT NULL,
    to_currency CHAR(3) NOT NULL,
    conversion_factor decimal(65,2) NOT NULL
);


--CREATE SEQUENCE cambio_id_seq
--      INCREMENT 1
--      MINVALUE 1
--      MAXVALUE 9223372036854775807
--      START 1
--      CACHE 1;
--ALTER TABLE cambio ALTER COLUMN id SET DEFAULT NEXTVAL("cambio_id_seq"::regclass);