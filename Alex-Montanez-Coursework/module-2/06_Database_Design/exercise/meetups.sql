START TRANSACTION;

DROP TABLE IF EXISTS event, interestGroup, member CASCADE;

-- Member table
CREATE TABLE members
(
	member_id serial,
	first_name varchar(64) not null,
	last_name varchar(64) not null,
	email_address varchar (64) not null,
	phone_number varchar (20),
	date_of_birth date not null,
	wants_emails boolean not null,
	
	CONSTRAINT pk_members PRIMARY KEY (member_id)
);

SELECT * FROM members;

-- Interest Group table
CREATE TABLE interest_groups
(
	group_id serial,
	name varchar (64) not null,
	
	CONSTRAINT pk_interest_groups PRIMARY KEY (group_id),
	CONSTRAINT uq_interest_groups UNIQUE (name)
);

SELECT * from interest_groups;		

-- Event table
CREATE TABLE events
(
	event_id serial,
	name varchar (64) not null,
	description varchar (500),
	start_date date,
	start_time time,
	duration_minutes int not null,
	
	CONSTRAINT pk_events PRIMARY KEY (event_id)
);

SELECT * from events;

-- Group/Member table
CREATE TABLE group_members
(
	member_id int not null,
	group_id int not null,
	
	CONSTRAINT pk_group_members_m PRIMARY KEY (member_id),
	CONSTRAINT fk_group_members_member FOREIGN KEY (member_id) REFERENCES members (member_id),
	CONSTRAINT fk_group_members_group FOREIGN KEY (group_id) REFERENCES interest_groups (group_id)
);

SELECT * from group_members;

INSERT INTO group_members (member_id, group_id)
VALUES (2, 1),
	   (5, 1),
	   (1, 2),
	   (3, 2),
	   (4, 3),
	   (7, 3);

-- Event Members table
CREATE TABLE event_members
(
	member_id int not null,
	event_id int not null,
	
	CONSTRAINT pk_event_members_m PRIMARY KEY (member_id),
	CONSTRAINT fk_event_members_member FOREIGN KEY (member_id) REFERENCES members (member_id),
	CONSTRAINT fk_event_members_event FOREIGN KEY (event_id) REFERENCES events (event_id)
);

SELECT * from event_members;


INSERT INTO members (first_name, last_name, email_address, phone_number, date_of_birth, wants_emails)
VALUES ('Alex', 'Montanez', 'montanez2693@gmail.com', '(216) 571-7479', '11/26/1993', true),
	   ('LeBron', 'James', 'lebronjames23@nba.com', '(330) 230-0606', '12/30/1984', true),
	   ('Nick', 'Chubb', 'nchubb24@nfl.com', '(440) 241-2024', '12/27/1995', false),
	   ('Stefan', 'Pastorcic', 'spastorcic@aol.com', '(440) 525-1757', '11/05/1992', true),
	   ('Hingle', 'McCringleberry', 'hinglem@keyandpeele.com', '(567) 223-4532', '06/04/1933', false),
	   ('Jeff', 'Bezos', 'jbezos@amazon.gov', '(254) 342-8439', '01/12/1964', false);
	   
INSERT INTO members (first_name, last_name, email_address, date_of_birth, wants_emails)
VALUES ('Eugene', 'Krabs', 'krustykrab02@bikinibottom.com', '04/03/1973', false),
	   ('Aubrey', 'Graham', 'drake@drake.net', '10/24/1984', true);
	   
	   

INSERT INTO interest_groups (name)
VALUES ('NBA'),
	   ('American Eagle'),
	   ('NFL');
	   
	   
INSERT INTO events (name, description, start_date, start_time, duration_minutes)
VALUES ('NBA Summer Bash', 'Hang with the superstars of the NBA!', '10/20/2024', '19:00:00', 180),
       ('American Eagle Parade', 'Walk with us in your favorite American Eagle gear!', '01/23/2025', '14:00:00', 300),
	   ('Super Bowl Party', 'Enjoy the Super Bowl with us!', '02/11/2025', '20:00:00', 360),
	   ('2025 NFL Draft', 'Celebrate your new draft picks with us!', '04/04/2025', '18:00:00', 240);	   
	   	   

INSERT INTO event_members (member_id, event_id)
VALUES (2, 1),
	   (4, 2),
	   (8, 3),
	   (6, 4);
	   
	   
	   
ROLLBACK;	   

COMMIT;