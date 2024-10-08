-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
SELECT DISTINCT person_name, birthday
FROM person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE birthday BETWEEN '1/1/1950' AND '12/31/1959' AND release_date BETWEEN '1/1/1985' AND '12/31/1985'
ORDER BY birthday;

