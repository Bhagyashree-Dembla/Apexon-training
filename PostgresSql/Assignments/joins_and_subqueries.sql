

-- question 1
SELECT b.starttime
FROM bookings b
JOIN members m 
  ON b.memid = m.memid
WHERE m.firstname = 'David'
  AND m.surname = 'Farrell';

-- question 2
SELECT b.starttime, f.name AS facility_name
FROM bookings b
JOIN facilities f 
  ON b.facid = f.facid
WHERE f.name ILIKE '%Tennis Court%'
  AND DATE(b.starttime) = '2012-09-21'
ORDER BY b.starttime;

-- question 3
SELECT DISTINCT m1.firstname, m1.surname
FROM members m1
JOIN members m2 
  ON m1.memid = m2.recommendedby
ORDER BY m1.surname, m1.firstname;

-- question 4
SELECT 
    m.firstname AS memfname, m.surname AS memsname,
    r.firstname AS recfname, r.surname AS recsname 
FROM members m
LEFT JOIN members r 
  ON m.recommendedby = r.memid
ORDER BY m.surname, m.firstname;

-- question 5
SELECT *
FROM (
    SELECT DISTINCT 
           m.firstname || ' ' || m.surname AS member_name,
           f.name AS facility_name
    FROM members m
    JOIN bookings b 
      ON m.memid = b.memid
    JOIN facilities f 
      ON b.facid = f.facid
    WHERE f.name ILIKE '%Tennis Court%'
) sub
ORDER BY member_name, facility_name;

-- question 6
SELECT 
    f.name AS facility_name,
    m.firstname || ' ' || m.surname AS member_name,
    (b.slots * 
       CASE 
           WHEN m.memid = 0 THEN f.guestcost 
           ELSE f.membercost 
       END
    ) AS cost
FROM bookings b
JOIN facilities f 
  ON b.facid = f.facid
JOIN members m 
  ON b.memid = m.memid
WHERE DATE(b.starttime) = '2012-09-14'
  AND (b.slots * 
       CASE 
           WHEN m.memid = 0 THEN f.guestcost 
           ELSE f.membercost 
       END
  ) > 30
ORDER BY cost DESC;

-- question 7
SELECT 
    m.firstname || ' ' || m.surname AS member_name,
    r.firstname || ' ' || r.surname AS recommender_name
FROM members m
LEFT JOIN members r 
  ON m.recommendedby = r.memid
ORDER BY m.firstname, m.surname;

-- question 8
SELECT facility_name, member_name, cost
FROM (
    SELECT 
        f.name AS facility_name,
        m.firstname || ' ' || m.surname AS member_name,
        (b.slots * 
           CASE 
               WHEN m.memid = 0 THEN f.guestcost 
               ELSE f.membercost 
           END
        ) AS cost,
        b.starttime
    FROM bookings b
    JOIN facilities f 
      ON b.facid = f.facid
    JOIN members m 
      ON b.memid = m.memid
) sub
WHERE DATE(starttime) = '2012-09-14'
  AND cost > 30
ORDER BY cost DESC;

-- question 9

-- question 10

-- question 11

-- question 12