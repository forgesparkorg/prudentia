-- V1.0__create_table_customer.sql
-- Description: Create table customer.

CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE customer
(
    id         BIGINT PRIMARY KEY DEFAULT NEXTVAL('customer_seq'),
    created_at TIMESTAMPTZ        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ        DEFAULT CURRENT_TIMESTAMP NOT NULL,
    name       VARCHAR(100)                                 NOT NULL,
    cpf        VARCHAR(14)                                  NOT NULL UNIQUE,
    birth_date DATE                                         NOT NULL,
    email      VARCHAR(255)                                 NOT NULL UNIQUE,
    phone      VARCHAR(15)                                  NOT NULL
)