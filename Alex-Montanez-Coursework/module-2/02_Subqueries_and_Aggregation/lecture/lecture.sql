-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ' (' || state_abbreviation || ')') AS city_state_abbreviation
FROM city
ORDER BY city_name;

SELECT (city_name || ', ' || state_abbreviation) AS city_state_abbreviation
FROM city
ORDER BY city_name;

SELECT (city_name || ', ' || state_abbreviation) AS city_state_abbreviation
FROM city
ORDER BY state_abbreviation, city_name;

SELECT CONCAT(city_name, ' (', state_abbreviation, ')') AS city_state_abbreviation
FROM city
ORDER BY city_name;

SELECT CONCAT(city_name, state_abbreviation) AS city_state_abbreviation
FROM city
ORDER BY city_name;


-- The all parks by name and date established.
SELECT (park_name || ', ' || date_established) AS park_name_date_established
FROM park
ORDER BY park_name;

SELECT (park_name || ' was established on ' || date_established) AS comment
FROM park
ORDER BY date_established;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT (census_region || ': ' || state_name) AS region_and_state
FROM state
-- WHERE census_region ILIKE '%west'
ORDER BY region_and_state;

SELECT (census_region || ': ' || state_name) AS region_and_state
FROM state
WHERE census_region ILIKE '%west'
ORDER BY region_and_state;

SELECT * FROM state;

SELECT state_name, ((population * 1.0) / area) AS density
FROM state
ORDER BY state_name;

SELECT state_name, ROUND((population * 1.0) / area, 2) AS density
FROM state
ORDER BY density DESC;


-- SUBQUERIES

-- List all cities in the western census region
SELECT city_name, state_abbreviation
FROM city
ORDER BY state_abbreviation, city_name;

SELECT state_abbreviation
FROM state
WHERE census_region = 'West';


SELECT city_name, state_abbreviation
FROM city
WHERE state_abbreviation IN (SELECT state_abbreviation FROM state WHERE census_region = 'West')
ORDER BY state_abbreviation, city_name;
-- List all cities in states with "garden" in their nickname

SELECT city_name, state_abbreviation
FROM city
WHERE 
ORDER BY state_abbreviation, city_name;


SELECT state_abbreviation, state_nickname
FROM state
WHERE state_nickname ILIKE '%garden%'

SELECT city_name, state_abbreviation
FROM city
WHERE state_abbreviation IN (SELECT state_abbreviation FROM state WHERE state_nickname ILIKE '%garden%')
ORDER BY state_abbreviation, city_name;
-- Get the parks with the smallest and largest areas
SELECT park_name, MIN(area) AS smallest, MAX(AREA) as largest
FROM park;

SELECT park_name, area
FROM park
WHERE area = (SELECT MIN(area) FROM park) OR area = (SELECT MAX(area) FROM park);

SELECT MIN(area) FROM park;
SELECT MAX(area) FROM park;


-- Get the state name and census region for all states with a national park
SELECT state_abbreviation
FROM park_state;

SELECT state_name, census_region
FROM state
WHERE state_abbreviation IN (SELECT DISTINCT state_abbreviation FROM park_state)
ORDER BY census_region, state_name;

SELECT DISTINCT state_abbreviation
FROM park_state
ORDER BY state_abbreviation;

SELECT *
FROM park_state;

SELECT *
FROM park;


-- Subqueries aren't limited to WHERE clauses, can appear in SELECT list (must return only 1 result)
-- Include state name rather than the state abbreviation while counting the number of cities in each state,
--   ordered from most cities to least.



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS average_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_population
FROM state
WHERE census_region = 'West' or census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT COUNT(population) AS big_cities_count
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(state_nickname) AS nickname_count, COUNT(*) AS total_count
FROM state;

-- The area of the smallest and largest parks.



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(city_name) AS cities, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, ROUND(AVG(area), 2) AS avg_park_area
FROM park
GROUP BY has_camping;

SELECT AVG(area) AS average_park_area, has_camping
FROM park
GROUP BY has_camping;

SELECT COUNT(city_name) AS num_cities, state_abbreviation
FROM city
WHERE state_abbreviation <> 'DC'
ORDER BY state_abbreviation;



-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS population_by_city 
FROM city
GROUP BY state_abbreviation
ORDER BY population_by_city DESC;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city;


SELECT AVG(population) AS average_population
FROM state;
WHERE census_region = 'West';

SELECT state_name
FROM state
WHERE census_region = 'West';

SELECT census_region FROM state WHERE census_region = 'Northwest' OR census_region = 'Midwest'


SELECT city_name, state_abbreviation, population
FROM city
WHERE census_region IN (SELECT census_region FROM state WHERE census_region = 'Northeast' OR census_region = 'Midwest')
ORDER BY state_abbreviation, population DESC;

SELECT COUNT(state_name) AS num_states, census_region
FROM state
WHERE census_region IS NOT NULL
GROUP BY census_region
ORDER BY num_states DESC;

SELECT state_abbreviation, MAX(population) AS city_population
FROM city
GROUP BY state_abbreviation
ORDER BY population DESC;

SELECT census_region, AVG(population) AS average_population, MIN(population) AS min_population, MAX(population) AS max_population
FROM state
WHERE census_region IS NOT NULL
ORDER BY average_population;

SELECT census_region, AVG(population) AS average_population, MIN(population) AS min_population, MAX(population) AS max_population
FROM state
WHERE census_region IS NOT NULL
GROUP BY census_region
ORDER BY average_population;