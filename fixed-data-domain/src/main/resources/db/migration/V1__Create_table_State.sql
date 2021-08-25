DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_tables WHERE tablename = 'state') THEN
        CREATE TABLE state (
            state_id uuid NOT NULL DEFAULT gen_random_uuid(),
            name VARCHAR(50) NOT NULL,
            initials VARCHAR(2) NOT NULL,
            CONSTRAINT state_pk PRIMARY KEY (state_id)
        );

        COMMENT ON TABLE state IS 'Table to store brazilian states';
        COMMENT ON COLUMN state.state_id IS 'The id of a State in this table.';
        COMMENT ON COLUMN state.name IS 'The name of the State.';

        CREATE INDEX state_name_idx ON public.state (name ASC NULLS LAST);

        RAISE INFO 'Added state table';
    ELSE
        RAISE INFO 'state table already added';
    END IF;
END
$$;

DO $$
   begin
      IF EXISTS (SELECT 1 FROM pg_tables WHERE tablename = 'state') THEN
         drop function if exists state_insert;

         CREATE FUNCTION state_insert(_name varchar(50), _initials varchar(2))
         RETURNS void AS
         $BODY$
            begin
               IF NOT EXISTS (SELECT 1 FROM public.state WHERE name=_name) then
                  INSERT INTO public.state (name, initials)
                  VALUES (_name, _initials);
               ELSE
                  RAISE NOTICE 'state name=% already exists', _code;
               END IF;
            END;
         $BODY$
         LANGUAGE 'plpgsql' volatile COST 100;

         perform state_insert('Acre','AC');
         perform state_insert('Alagoas','AL');
         perform state_insert('Amapá','AP');
         perform state_insert('Amazonas','AM');
         perform state_insert('Bahia','BA');
         perform state_insert('Brasília (Distrito Federal)','DF');
         perform state_insert('Ceará','CE');
         perform state_insert('Espírito Santo','ES');
         perform state_insert('Exterior','EX');
         perform state_insert('Goiás','GO');
         perform state_insert('Maranhão','MA');
         perform state_insert('Mato Grosso','MT');
         perform state_insert('Mato Grosso do Sul','MS');
         perform state_insert('Minas Gerais','MG');
         perform state_insert('Pará','PA');
         perform state_insert('Paraíba','PB');
         perform state_insert('Paraná','PR');
         perform state_insert('Pernambuco','PE');
         perform state_insert('Piauí','PI');
         perform state_insert('Rio de Janeiro','RJ');
         perform state_insert('Rio Grande do Norte','RN');
         perform state_insert('Rio Grande do Sul','RS');
         perform state_insert('Rondonia','RO');
         perform state_insert('Roraima','RR');
         perform state_insert('Santa Catarina','SC');
         perform state_insert('São Paulo','SP');
         perform state_insert('Sergipe','SE');
         perform state_insert('Tocantins','TO');

         drop function if exists state_insert;
      end if;
    end $$;