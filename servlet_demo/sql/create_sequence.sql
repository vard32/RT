CREATE SEQUENCE public.auto_ids
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 36
  CACHE 1;
ALTER TABLE public.auto_ids
  OWNER TO postgres;
