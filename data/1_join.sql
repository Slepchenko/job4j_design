create table departments(
	id serial,
	name text
);

create table emploers(
	departments_id int primary key,
	name text
);

insert into departments(name) values('depart_1');
insert into departments(name) values('depart_2');
insert into departments(name) values('depart_3');
insert into departments(name) values('depart_4');
insert into departments(name) values('depart_5');
insert into departments(name) values('depart_6');

insert into emploers(departments_id, name) values('1', 'emploer_1');
insert into emploers(departments_id, name) values('2', 'emploer_2');
insert into emploers(departments_id, name) values('3', 'emploer_3');
insert into emploers(departments_id, name) values('4', 'emploer_4');

--3.
select d.name, e.name
from departments d
left join emploers e on d.id = e.departments_id
where e.name is null;

--4.
select d.name, e.name
from emploers e
right join departments d on e.departments_id = d.id
where e.name is null;

--5
create table teens(
	id serial,
	name text,
	gender text
);

insert into teens(name, gender) values('Витя', 'м');
insert into teens(name, gender) values('Никитка', 'м');
insert into teens(name, gender) values('Маша', 'ж');
insert into teens(name, gender) values('Валера', 'м');
insert into teens(name, gender) values('Даша', 'ж');

select t1.name as "М", t2.name as "Ж"
from teens t1
cross join teens t2
where t1.gender != t2.gender;


