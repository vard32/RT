CREATE TABLE public.mytable
(
  id integer NOT NULL DEFAULT nextval('auto_ids'::regclass),
  "FirstName" character varying(255),
  "SecondName" character varying(255),
  "LastName" character varying(255),
  "Receiver" character varying(255),
  "Theme" character varying(255),
  "Message" character varying(255),
  CONSTRAINT id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.mytable
  OWNER TO postgres;
