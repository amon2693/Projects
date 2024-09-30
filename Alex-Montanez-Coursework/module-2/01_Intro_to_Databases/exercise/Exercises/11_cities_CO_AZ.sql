-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ).
-- Order the results by state abbreviation alphabetically (A-Z), then by population (highest first).
-- (22 rows)
SELECT city_name, state_abbreviation, population
FROM city
WHERE state_abbreviation IN ('CO', 'AZ')
ORDER BY state_abbreviation, population DESC;
