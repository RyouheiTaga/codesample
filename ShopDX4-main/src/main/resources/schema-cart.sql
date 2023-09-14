-- Table: public.cart

DROP TABLE IF EXISTS public.cart;

CREATE TABLE IF NOT EXISTS public.cart
(
    code integer NOT NULL,
    uid integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price integer NOT NULL,
    buynum integer NOT NULL,
    CONSTRAINT cart_pkey PRIMARY KEY (code, uid)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cart
    OWNER to postgres;