CREATE OR REPLACE FUNCTION create_table()
    RETURNS void
    LANGUAGE plpgsql AS
$func$
BEGIN
    IF exists(SELECT FROM pg_catalog.pg_tables WHERE tablename = 'Documents') THEN
        RAISE NOTICE 'Table "table_name" already exists.';
    ELSE
        CREATE TABLE "table_name"
        (
            -- table columns data...
        );
    END IF;
END;
$func$;

SELECT create_table();
