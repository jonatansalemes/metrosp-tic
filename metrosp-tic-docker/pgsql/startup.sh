#!/bin/bash
pg_ctlcluster 12 main start
psql -v ON_ERROR_STOP=1 --username "postgres" --dbname "postgres" <<-EOSQL
    
    CREATE USER metrosptic WITH PASSWORD 'metrosptic';
    CREATE DATABASE metrosptic;
    
    CREATE USER bot WITH PASSWORD 'bot';
	CREATE DATABASE bot;
	
	\connect bot
	CREATE SCHEMA bot AUTHORIZATION bot;
	
	\connect metrosptic
	CREATE SCHEMA metrosptic AUTHORIZATION metrosptic;
	create table metrosptic.ticket (full_name varchar(100) not null,phone varchar(100) not null,email varchar(100) not null,id_software_version bigint not null, hostname varchar(100) not null, ip varchar(100) not null);
	ALTER TABLE metrosptic.ticket OWNER TO metrosptic;
EOSQL
