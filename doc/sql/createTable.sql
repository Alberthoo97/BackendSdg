
CREATE TABLE IF NOT EXISTS public.country
(
    population bigint NOT NULL,
    name_country text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT country_pkey PRIMARY KEY (name_country)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.country
    OWNER to postgres;

COMMENT ON TABLE public.country
    IS 'Tabla que contiene la información relativa de los paises';