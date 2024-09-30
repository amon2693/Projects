-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set
--     their collection ID to the "Bill Murray Collection". (1 row, 6 rows)
INSERT INTO collection (collection_name)
VALUES ('Bill Murray Collection');

UPDATE collection
SET collection_id = (SELECT person_id FROM person WHERE person_name = 'Bill Murray');
WHERE collection_name = 'Bill Murray Collection';
