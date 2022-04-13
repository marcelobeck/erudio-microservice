CREATE TABLE IF NOT EXISTS public.cambio (
    id SERIAL PRIMARY KEY,
    from_currency CHARACTER VARYING,
    to_currency CHARACTER VARYING,
    conversion_factor decimal(65,2) NOT NULL
   )