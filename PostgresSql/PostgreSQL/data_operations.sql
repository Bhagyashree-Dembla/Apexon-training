CREATE TABLE performance
 
(fl_date date, 
mkt_carrier character varying(2), 
mkt_carrier_fl_num character varying(4), 
origin character varying(3), 
origin_city_name character varying(45), 
origin_state_abr character varying(2), 
dest character varying(3), 
dest_city_name character varying(45), 
dest_state_abr character varying(2), 
dep_delay_new numeric, 
arr_delay_new numeric, 
cancelled numeric, 
cancellation_code character varying(2), 
diverted numeric, 
carrier_delay numeric, 
weather_delay numeric, 
nas_delay numeric, 
security_delay numeric, 
late_aircraft_delay numeric);
 
--set up the date format as per excel 
SET datestyle = 'ISO, MDY'; 
COPY public.performance (fl_date, mkt_carrier, mkt_carrier_fl_num, origin, origin_city_name, origin_state_abr, dest, dest_city_name, dest_state_abr, dep_delay_new, arr_delay_new, cancelled, cancellation_code, diverted, carrier_delay, weather_delay, nas_delay, security_delay, late_aircraft_delay)
FROM 'C:/Handson/GS-Training/Training Materials/8. PostgreSQL/1. Querying Data from PostgreSQL/Demonstration Tables/OntimeCarrier.csv'  
DELIMITER ','  
CSV HEADER ENCODING 'UTF8'  
QUOTE '"'  
ESCAPE '''';
 
CREATE TABLE codes_cancellation 
(cancellation_code character varying(2), 
           cancel_desc character varying(45));
 
INSERT INTO codes_cancellation (cancellation_code, cancel_desc) 
VALUES 
('A','Carrier'), 
('B','Weather'), 
('C','National Air System'), 
('D','Security');
 
CREATE TABLE codes_carrier 
(carrier_code character varying(2), 
carrier_desc character varying(45));
 
INSERT INTO codes_carrier (carrier_code, carrier_desc) 
VALUES 
('AA','American Airlines'), 
('AS','Alaska Airlines'), 
('B6','JetBlue Airways'), 
('DL','Delta Air Lines'), 
('F9','Frontier Airlines'), 
('G4','Allegiant Air'), 
('HA','Hawaiian Airlines'), 
('NK','Spirit Air Lines'), 
('UA','United Air Lines'), 
('VX','Virgin America'), 
('WN','Southwest Airlines');
 
-- ============================================
-- 3. Selecting Your Data
-- =============================================
--first 10 rows values are displayed 
SELECT * FROM public.performance
LIMIT 100;
 
  SELECT * FROM public.codes_carrier;
 
--alias 
  SELECT  mkt_carrier AS airline, 
  mkt_carrier_fl_num AS flight, 
  origin AS depart_city 
  FROM public.performance;
 
--what flight departed from a certain airport? 
SELECT  *
FROM public.performance
WHERE origin = 'LAS' and fl_date = '2018-01-31';
 
--distinct value of single column
SELECT DISTINCT mkt_carrier
FROM performance;
 
--distinct value - combination will be distinct
SELECT DISTINCT mkt_carrier, mkt_carrier_fl_num
FROM performance;
 
 
-- ============================================
-- 4. Limiting Your Results
-- =============================================
SELECT fl_date, mkt_carrier AS airline, mkt_carrier_fl_num AS flight, 
origin,dest
FROM performance
WHERE 
-- origin = 'ORD'
dest = 'ORD' AND origin ='BZN';
 
 
--matching pattern (LIKE...)
SELECT fl_date, mkt_carrier AS airline, mkt_carrier_fl_num AS flight, origin_city_name
FROM performance
WHERE origin_city_name LIKE 'Fort%';
 
--Fuzzy matching
SELECT DISTINCT origin_city_name
FROM performance
-- WHERE origin_city_name LIKE 'Fort%';
-- WHERE origin_city_name LIKE 'New%LA';
-- WHERE origin_city_name LIKE '____, KS';
WHERE origin_city_name LIKE '____, %';
 
---------NULL VALUES
SELECT fl_date, mkt_carrier AS airline, mkt_carrier_fl_num AS flight, cancellation_code
FROM performance
-- WHERE cancellation_code IS NOT NULL;
WHERE cancellation_code IS NULL;
 
----------------BETWEEN KEYWORD
SELECT fl_date, mkt_carrier AS airline, mkt_carrier_fl_num AS flight
FROM performance
-- WHERE fl_date >= '2018-01-02' AND fl_date <='2018-01-03';
WHERE fl_date BETWEEN '2018-01-02' AND '2018-01-03';
 
-------IN keyword
SELECT fl_date, mkt_carrier AS airline, mkt_carrier_fl_num AS flight
FROM performance
-- WHERE fl_date = '2018-01-02' OR fl_date =  '2018-01-03' OR fl_date = '2018-01-04';
WHERE fl_date IN ('2018-01-02', '2018-01-03', '2018-01-04');
 
 
-- ============================================
-- 5. Joining for further insight
-- =============================================
 
SELECT p.fl_date,
p.mkt_carrier,
c.carrier_desc AS airline,
p.mkt_carrier_fl_num AS fight, 
p.origin_city_name,
p.dest_city_name,
p.cancellation_code,
ca.cancel_desc
FROM performance p 
INNER JOIN codes_carrier c ON  c. carrier_code = p.mkt_carrier
LEFT JOIN codes_cancellation ca ON p.cancellation_code = ca.cancellation_code;
 
 
-- ============================================
-- 6. Presenting and aggregrating 
-- =============================================
 
SELECT AVG(dep_delay_new)
FROM performance;
 
SELECT mkt_carrier, AVG(dep_delay_new)
FROM performance 
GROUP BY mkt_carrier;
 
SELECT p.mkt_carrier, AVG(p.dep_delay_new),c.carrier_desc
FROM performance p
INNER JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code
GROUP BY p.mkt_carrier, c.carrier_desc
ORDER BY AVG(p.dep_delay_new) DESC;
 
SELECT p.mkt_carrier,c.carrier_desc, 
AVG(p.dep_delay_new) AS depature_delay,
AVG(p.arr_delay_new) AS arrival_delay
FROM performance p
INNER JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code
GROUP BY p.mkt_carrier, c.carrier_desc
-- ORDER BY AVG(p.dep_delay_new) DESC;
ORDER BY 3 DESC;
-- both works same 3 or avg(p.dep_delay_new)
 
 
SELECT p.mkt_carrier, AVG(p.dep_delay_new),c.carrier_desc
FROM performance p
INNER JOIN codes_carrier c ON p.mkt_carrier = c.carrier_code
GROUP BY p.mkt_carrier, c.carrier_desc
HAVING AVG(p.dep_delay_new) > 1 
AND AVG(p.arr_delay_new) > 5;
 
--Subqueries
--single--row subquery 
SELECT carrier_desc
FROM codes_carrier
WHERE carrier_code = (
	SELECT mkt_carrier
	FROM performance
	where mkt_carrier_fl_num = '2427'
	LIMIT 1
);
-- multiple-row subquery 
SELECT fl_date, mkt_carrier, mkt_carrier_fl_num, origin, dest, cancellation_code
FROM performance
where cancellation_code IN (
	SELECT cancellation_code
	FROM codes_cancellation
	where cancel_desc = 'Carrier'
);
-- find the flight deptaure delay > avg delay of their destination?
-- correalted subquery
SELECT fl_date,mkt_carrier, mkt_carrier_fl_num, origin, dest, dep_delay_new
FROM performance p1
where dep_delay_new > (
	SELECT AVG(dep_delay_new)
	FROM performance p2
	where p1.dest= p2.dest
); --dont run due to huge data calculation
 
--common table expression --- this runs faster than correlated subqueries
 
WITH AVGDelays AS (
	SELECT dest, AVG(dep_delay_new) AS avg_delay
	from performance
	group by dest
)
SELECT p1.fl_date,
		p1.mkt_carrier,
p1.mkt_carrier_fl_num, p1.origin, p1.dest, p1.dep_delay_new
FROM performance p1
JOIN AvgDelays A ON p1.dest = A.dest
Where dep_delay_new > a.avg_delay;
 
-- ================================
-- Database Views
-- ================================
 
CREATE VIEW flight_info AS
SELECT  p1.fl_date, p1.mkt_carrier,p1.mkt_carrier_fl_num, p1.origin, p1.dest, p1.dep_delay_new,
		c.carrier_desc
	FROM performance p1
	JOIN codes_carrier c ON p1.mkt_carrier = c.carrier_code;
 
 
SELECT * 
FROM flight_info
WHERE dep_delay_new >30;
-- view occupies memory
 
 
CREATE VIEW delay_summary AS
SELECT p.fl_date, p.origin, p.dest, p.dep_delay_new, p.arr_delay_new
FROM performance p
WHERE p.dep_delay_new IS NOT NULL
OR arr_delay_new IS NOT NULL;
 
SELECT * 
FROM delay_summary;
 
CREATE VIEW carrier_delay_summary AS
SELECT p.mkt_carrier ,  c.carrier_desc,
	AVG(p.dep_delay_new) AS avg_dep_delay,
	AVG(p.arr_delay_new) AS avg_arr_delay
FROM performance p JOIN AVGDelays ON p.dest = a.dest
Group by p.mkt_carrier ,  c.carrier_desc;

SELECT * FROM carrier_delay_summary;

 CREATE VIEW cancellation_info AS
 SELECT 
 p.fl_date,
 p.mkt_carrier_fl_num,
 p.origin,
 p.dest,
 cc.cancel_desc
 	FROM performance p
	 JOIN codes_cancellation cc
	 ON p.cancellation_code = cc.cancellation_code 
	 WHERE p.cancelled = 1;

Select * FROM cancellation_info;
 
-- ================================
-- Optimizing queries
-- ================================
 -- indexing 
 CREATE INDEX idx_performance_fl_date
 ON performance(fl_date); --postgresSql builds a b-tree structure

 SELECT * 
 FROM performance WHERE fl_date = '2018-01-21';

-- Functions on indexed

-- bad example
SELECT *
	FROM performance
	WHERE DATE(fl_date) = '2018-01-21';

-- good example
SELECT *
	FROM performance
	WHERE fl_date >= '2018-01-21' :: date --cast to date
	AND fl_date < '2018-01-31' :: date;

--Filtering early
EXPLAIN ANALYZE
SELECT p1.fl_date, p1.mkt_carrier, c.carrier_desc, cc.cancel_desc, p1.origin, p1.dest
FROM performance p1
JOIN codes_carrier c ON p1.mkt_carrier = c.carrier_code 
JOIN codes_cancellation cc ON cc.cancellation_code = p1.cancellation_code
WHERE p1.cancelled =1; --SCAN -> FILTER(on the fly) -> join only surviving rows.

CREATE INDEX idx_performance_mkt_carrier
ON performance(mkt_carrier);

CREATE INDEX idx_performance_cancellation_code
ON performance(cancellation_code);

--Exists
SELECT fl_date,
	mkt_carrier,
	origin,
	dest
	FROM performance p 
	WHERE EXISTS (
		SELECT 1 FROM codes_carrier c  
		WHERE c.carrier_code = p.mkt_carrier);
SELECT * FROM codes_carrier c;

--EXPLAIN
EXPLAIN
SELECT * FROM performance
 WHERE dep_delay_new > 30;

EXPLAIN 
SELECT p1.fl_date, p1.mkt_carrier, c.carrier_desc, cc.cancel_desc, p1.origin, p1.dest
FROM performance p1
JOIN codes_carrier c ON p1.mkt_carrier = c.carrier_code 
JOIN codes_cancellation cc ON cc.cancellation_code = p1.cancellation_code
WHERE p1.cancelled =1; 
