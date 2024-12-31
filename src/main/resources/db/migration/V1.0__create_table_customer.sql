CREATE TABLE customer
(
    id         UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    name       VARCHAR(100) NOT NULL,
    last_name  VARCHAR(120),
    cpf        VARCHAR(14)  NOT NULL UNIQUE,
    birth_date DATE         NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    phone      VARCHAR(15)  NOT NULL,

    CONSTRAINT chk_birth_date_past CHECK (birth_date < CURRENT_DATE)
);

CREATE INDEX idx_customer_email ON customer (email);
CREATE INDEX idx_customer_cpf ON customer (cpf);
CREATE INDEX idx_customer_phone ON customer (phone);