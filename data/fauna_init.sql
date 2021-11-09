create table fauna (
	id serial primary key,
	name text,
	avg_age int,
	discorery_date date
);

insert into fauna(id, name, avg_age, discorery_date) values('1', 'Pollock fish', '14', '01.02.1814');
insert into fauna(id, name, avg_age, discorery_date) values('2', 'Cod', '12', '22.12.1758');
insert into fauna(id, name, avg_age, discorery_date) values('3', 'flounder', '25', null);
insert into fauna(id, name, avg_age, discorery_date) values('4', 'Fish navaga', '9', '21.09.1792');
insert into fauna(id, name, avg_age, discorery_date) values('5', 'halibut', '24', null);
insert into fauna(id, name, avg_age, discorery_date) values('6', 'Clupea bentincki', null, '21.05.1936');
insert into fauna(id, name, avg_age, discorery_date) values('7', 'Clupea harengus', '22', '28.09.1758');
insert into fauna(id, name, avg_age, discorery_date) values('8', 'Clupea pallasii', '19', '04.10.1847');
insert into fauna(id, name, avg_age, discorery_date) values('9', 'Scomber australasicus', '18', '12.06.1832');
insert into fauna(id, name, avg_age, discorery_date) values('10', 'Scomber australasicus', '18', '19.07.1789');
insert into fauna(id, name, avg_age, discorery_date) values('11', 'Scomber japonicus', '18', '20.08.1782');
insert into fauna(id, name, avg_age, discorery_date) values('12', 'Oncorhynchus gorbuscha', '7', '21.09.1792');
insert into fauna(id, name, avg_age, discorery_date) values('13', 'Salmo salar', '7', '22.10.1758');
insert into fauna(id, name, avg_age, discorery_date) values('14', 'Oncorhynchus keta', '7', '23.11.1792');
insert into fauna(id, name, avg_age, discorery_date) values('15', 'Oncorhynchus tshawytscha', '7', '30.03.1792');
insert into fauna(id, name, avg_age, discorery_date) values('16', 'Oncorhynchus kisutch', '7', '24.12.1792');
insert into fauna(id, name, avg_age, discorery_date) values('17', 'non-existent fish', '999', '01.01.2021');


select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discorery_date is null;
select * from fauna where discorery_date < '01.01.1950';
