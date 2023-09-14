-- Table: public.buyhistory

DROP TABLE IF EXISTS public.buyhistory;

CREATE TABLE  IF NOT EXISTS public.buyhistory
(
    code integer NOT NULL,
    uid integer NOT NULL,
    name character varying(255) NOT NULL,
    PRIMARY KEY (code, uid)
);

ALTER TABLE IF EXISTS public.buyhistory
    OWNER to postgres;