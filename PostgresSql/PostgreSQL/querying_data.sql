-- Database: dvdrental

-- DROP DATABASE IF EXISTS dvdrental;

CREATE DATABASE dvdrental
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_India.1252'
    LC_CTYPE = 'English_India.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

	SELECT * FROM film;

	--Subtask 1: Change the name of the actor from Cuba to Jacob

	SELECT * FROM Actor WHERE first_name = 'Jacob';

	--Using Update clause
	UPDATE Actor 
	SET first_name = 'Jacob'
	WHERE first_name = 'Cuba';


	-- Subtask 2: Insert a row into the table with actor name Robert Johnson

	INSERT INTO Actor(first_name, last_name)
	VALUES('Robert', 'Johnson');

	--Select Dataq
	SELECT *
	FROM Actor
	WHERE first_name = 'Robert';

	-- =================
	-- Scenario 2
	-- ====================
-- Subtask 1: Delete all rows where first name of actor is Robert
-- Select Data
	SELECT * FROM Actor 
	WHERE first_name = 'Robert';

	DELETE FROM Actor WHERE first_name = 'Robert';