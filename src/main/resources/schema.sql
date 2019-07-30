DROP TABLE IF EXISTS arvostelut;
DROP TABLE IF EXISTS ravintolat;
CREATE TABLE ravintolat (id SERIAL PRIMARY KEY, nimi VARCHAR(255), paikkakunta VARCHAR(255), osoite VARCHAR(255), tyyppi VARCHAR(255)); 
CREATE TABLE arvostelut (id SERIAL PRIMARY KEY, ravintola INTEGER REFERENCES ravintolat(id), arvosana INTEGER, arvio VARCHAR(255));