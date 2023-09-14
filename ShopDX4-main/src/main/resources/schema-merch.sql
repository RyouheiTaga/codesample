-- Table: public.merch

DROP TABLE IF EXISTS public.merch;

CREATE TABLE IF NOT EXISTS public.merch
(
    code integer NOT NULL,
    eos date,
    price integer NOT NULL,
    regiday date,
    stock integer NOT NULL,
    update date,
    attribute character varying(255) COLLATE pg_catalog."default",
    category character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT merch_pkey PRIMARY KEY (code)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.merch
    OWNER to postgres;