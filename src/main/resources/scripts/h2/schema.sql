
--DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA IF NOT EXISTS public;

DROP TABLE IF EXISTS public."User";

CREATE TABLE IF NOT EXISTS public."User"
(
    id bigint auto_increment primary key,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL
)
