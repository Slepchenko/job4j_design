create table body (
	id serial primary key,
	name text
);

create table engine (
	id serial primary key,
	name text
);

create table transmission (
	id serial primary key,
	name varchar(255)
);

insert into body(name) values('Универсал');
insert into body(name) values('Седан');
insert into body(name) values('Купэ');
insert into body(name) values('Пикап');
insert into body(name) values('Лимузин');
insert into body(name) values('Камаз')

insert into engine(name) values('V-образный');
insert into engine(name) values('Рядный');
insert into engine(name) values('Оппозитный');
insert into engine(name) values('Электродвигатель')

insert into transmission(name) values ('Механическая коробка передач');
insert into transmission(name) values ('Коробка автомат');
insert into transmission(name) values ('Гидравлическая трансмиссия')

create table cars(
	id serial primary key,
	registration_number text,
	body_id int,
	engine_id int,
	transmission_id int
);

insert into cars(registration_number, body_id, engine_id, transmission_id) values ('В260АХ', 1, 1, 1);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('Г332УЕ', 1, 3, 1);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('Д532ОИ', 2, 1, 1);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('А775ХУ', 2, 3, 2);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('В112СС', 2, 2, 2);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('Н222ЕИ', 2, 3, 1);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('Р875ОН', 3, 2, 1);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('О666ХХ', 3, 3, 1);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('С282ГН', 3, 1, 2);
insert into cars(registration_number, body_id, engine_id, transmission_id) values ('Т090КГ', 3, 1, 1);

--1.
select registration_number, body.name as "Корпус", engine.name as "Двигатель", transmission.name as "Коробка"
from cars
join body on cars.body_id = body.id
join engine on cars.engine_id = engine.id
join transmission on cars.transmission_id = transmission.id

--2.
select registration_number, body.name as "Корпус"
from cars
right join body on cars.body_id = body.id
where registration_number is null;

select registration_number, engine.name as "Двигатель"
from cars
right join engine on cars.engine_id = engine.id
where registration_number is null;

select registration_number, transmission.name as "Коробка"
from cars
right join transmission on cars.transmission_id = transmission.id
where registration_number is null;


