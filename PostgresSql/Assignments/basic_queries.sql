-- question1 
select * from  facilities;

-- question 2
SELECT name, membercost
FROM facilities;

-- question 3
SELECT name, membercost
FROM facilities
WHERE membercost > 0;

-- question 4
SELECT facid, name, membercost, monthlymaintenance
FROM facilities
WHERE membercost > 0
  AND membercost < (monthlymaintenance / 50);
  
-- question 5
SELECT facid, name
FROM facilities
WHERE name ILIKE '%Tennis%';

-- question 6
SELECT *
FROM facilities
WHERE facid IN (1, 5);

-- question 7
SELECT 
    name,
    CASE 
        WHEN monthlymaintenance > 100 THEN 'Expensive'
        ELSE 'Cheap'
    END AS cost_category
FROM facilities;

-- question 8
SELECT memid, firstname, surname, joindate
FROM members
WHERE joindate > '2012-08-30';

-- question 9
SELECT DISTINCT surname
FROM members
ORDER BY surname
LIMIT 10;

-- question 10
SELECT surname AS name
FROM members
UNION
SELECT name
FROM facilities;

-- question 11
SELECT MAX(joindate) AS last_signup_date
FROM members;SELECT firstname, surname, joindate
FROM cd.members
ORDER BY joindate DESC
LIMIT 1;


-- question 12
SELECT firstname, surname, joindate
FROM members
ORDER BY joindate DESC
LIMIT 1;