-- select the park name, campground name, open_from_mm, open_to_mm & daily_fee ordered by park name and then campground name
-- (expected: 7 rows, starting with "Blackwoods")
SELECT p.name, c.name, c.open_from_mm, c.open_to_mm, c.daily_fee
from campground c join park p
on c.park_id = p.park_id
order by p.name, c.name;

-- select the park name and the total number of campgrounds for each park ordered by park name
-- (expected: 3 rows, starting with "Acadia")
SELECT p.name, COUNT(c.campground_id)
From park p left join campground c
on p.park_id = c.park_id
group by p.park_id, p.name
order by p.name;

-- select the park name, campground name, site number, max occupancy, accessible, max rv length, utilities where the campground name is 'Blackwoods'
-- (expected: 12 rows)
SELECT p.name, c.name, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, s.utilities
From park p left join campground c
on p.park_id = c.park_id
join site s
on s.campground_id = c.campground_id
where c.name = 'Blackwoods';

-- select site number, reservation name, reservation from and to date ordered by reservation from date
-- (expected: 44 rows, starting with the earliest date)
SELECT s.site_number, r.name, r.from_date, r.to_date
FROM site s join reservation r
on s.site_id = r.site_id
ORDER BY r.from_date;
