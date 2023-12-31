
DROP SCHEMA public CASCADE;
CREATE SCHEMA IF NOT EXISTS public;
DROP TABLE IF EXISTS public."User";

CREATE TABLE IF NOT EXISTS public."User"
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( START WITH 1, INCREMENT BY 1),
    name varchar(255),
    email varchar(255),
    CONSTRAINT "user_pk" PRIMARY KEY (id)
)
