CREATE OR REPLACE FUNCTION create_table()
    RETURNS void
    LANGUAGE plpgsql AS
$func$
BEGIN
    IF exists(SELECT FROM pg_catalog.pg_tables WHERE tablename = 'Documents') THEN
        RAISE NOTICE 'Table Documents already exists.';
    ELSE
        CREATE TABLE Documents
        (
            id   integer primary key not null,
            name text                not null
        );
    END IF;
END;
$func$;

SELECT create_table();
