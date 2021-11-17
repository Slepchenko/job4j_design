create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price) values('breathalyzer', '150');
insert into devices(name, price) values('Calculator', '40');
insert into devices(name, price) values('fleshlight', '90');
insert into devices(name, price) values('Non-contact thermometer', '110');
insert into devices(name, price) values('weather forecaster', '45');
insert into devices(name, price) values('pocket scales', '82');
insert into devices(name, price) values('beer opener', '15');
insert into devices(name, price) values('spoon holder on the pan', '5');

insert into people(name) values('Vitya');
insert into people(name) values('Nikitka');
insert into people(name) values('Vitalik');

insert into devices_people(device_id, people_id) values('1', '1');
insert into devices_people(device_id, people_id) values('1', '3');
insert into devices_people(device_id, people_id) values('2', '2');
insert into devices_people(device_id, people_id) values('2', '3');
insert into devices_people(device_id, people_id) values('3', '2');
insert into devices_people(device_id, people_id) values('4', '1');
insert into devices_people(device_id, people_id) values('5', '3');
insert into devices_people(device_id, people_id) values('6', '1');
insert into devices_people(device_id, people_id) values('6', '2');
insert into devices_people(device_id, people_id) values('7', '2');
insert into devices_people(device_id, people_id) values('8', '1');
insert into devices_people(device_id, people_id) values('8', '2');

select avg(price) from devices;
select dp.people_id, avg(d.price) from devices as d join devices_people dp on dp.device_id = d.id group by dp.people_id;
select dp.people_id, avg(d.price) >= 5000 from devices as d join devices_people dp on dp.device_id = d.id group by dp.people_id;