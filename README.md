# Role_based_login
JAVA core 8 for training and learning--this basic system is app-based-web-ased is on the way 

The database is Postgress for it to connect and first login as an admin run the query below
-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default",
    role character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;
