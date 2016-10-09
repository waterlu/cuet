-- Table: public.resume

-- DROP TABLE public.resume;

DROP TABLE IF EXISTS resume;
CREATE TABLE resume
(
  id serial NOT NULL,
  name text NOT NULL,
  mobile text NOT NULL,
  create_time timestamp with time zone,
  update_time timestamp with time zone,
  deleted smallint DEFAULT 0,
  user_id bigint,
  gender smallint,
  birthday date,
  marital_status smallint,
  email text,
  qq text,
  hukou text,
  province text,
  city text,
  zone text,
  work_experience smallint,
  degree smallint,
  source smallint,
  resume_name text,
  introduction text,
  education json,
  PRIMARY KEY (id)
);