create table yachts(
	id serial primary key,
	ships_name text
);

create table participants(
	id serial primary key,
	name text,
	yachts_id int references yachts(id) unique
);

insert into yachts(id, ships_name) values('1', 'Bistriy');
insert into yachts(id, ships_name) values('2', 'Shustriy');
insert into yachts(id, ships_name) values('3', 'Stremitelniy');

insert into participants(id, name, yachts_id) values('1', 'Vitia', '1');
insert into participants(id, name, yachts_id) values('2', 'Vitalya', '2');
insert into participants(id, name, yachts_id) values('3', 'Valera', '3');
insert into participants(id, name) values('4', 'Tolya');
insert into participants(id, name) values('5', 'Diman');

select * from participants inner join yachts on participants.yachts_id = yachts.id;
select * from participants as p inner join yachts as y on p.yachts_id = y.id;
select p.name, y.ships_name from participants as p join yachts as y on p.yachts_id = y.id;
select p.name as Имя_допущеного_участника, y.ships_name as Название_яхты from yachts as y join participants as p on y.id = p.yachts_id;