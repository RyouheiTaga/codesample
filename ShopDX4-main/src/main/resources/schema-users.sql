-- Table: public.users

--DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    sei character varying(50) COLLATE pg_catalog."default" NOT NULL,
    sei2 character varying(50) COLLATE pg_catalog."default" NOT NULL,
    addr character varying(80) COLLATE pg_catalog."default" NOT NULL,
    tell character varying(20) COLLATE pg_catalog."default",
    mail character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    birthdate date NOT NULL,
    post integer NOT NULL,
    mei character varying(40) COLLATE pg_catalog."default" NOT NULL,
    mei2 character varying(40) COLLATE pg_catalog."default" NOT NULL,
    kana character varying(40) COLLATE pg_catalog."default" ,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;