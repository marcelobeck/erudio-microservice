CREATE TABLE IF NOT EXISTS public.book (
  id SERIAL PRIMARY KEY,
  author CHARACTER VARYING,
  launch_date VARCHAR,
  price decimal(65,2) NOT NULL,
  title CHARACTER VARYING
)
