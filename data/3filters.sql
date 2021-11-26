create table product(
	id serial primary key,
	name text,
	type_id int,
	expired_date date,
	price float
);

create table type(
	id serial primary key,
	name text
);

insert into type(name) values('Молоко');
insert into type(name) values('Сыр');
insert into type(name) values('Мороженое');
insert into type(name) values('Йогурт');
insert into type(name) values('Масло');

insert into product(name, type_id, expired_date, price)
values('Коровье', '1', '21.06.2021', '160');
insert into product(name, type_id, expired_date, price)
values('Козье', '1', '09.02.2021', '180');
insert into product(name, type_id, expired_date, price)
values('Лосиное', '1', '22.08.1984', '1199');
insert into product(name, type_id, expired_date, price)
values('Кобылье', '1', '15.11.2021', '295');
insert into product(name, type_id, expired_date, price)
values('Буйволиное', '1', '17.03.2020', '720');
insert into product(name, type_id, expired_date, price)
values('Золотое', '1', '29.09.2021', '358');
insert into product(name, type_id, expired_date, price)
values('Кокосовое', '1', '10.05.2021', '421');
insert into product(name, type_id, expired_date, price)
values('Конопляное', '1', '02.05.2021', '510');
insert into product(name, type_id, expired_date, price)
values('Соевое', '1', '12.12.2012', '143');
insert into product(name, type_id, expired_date, price)
values('Миндальное', '1', '03.01.2021', '377');
insert into product(name, type_id, expired_date, price)
values('Овсяное', '1', '21.12.2020', '299');
insert into product(name, type_id, expired_date, price)
values('Рисовое', '1', '17.04.2021', '127');
insert into product(name, type_id, expired_date, price)
values('Мышиное молоко', '1', '19.09.2021', '1400000');

insert into product(name, type_id, expired_date, price)
values('Москарпоне', '2', '10.08.2021', '250');
insert into product(name, type_id, expired_date, price)
values('Моцарелла', '2', '15.02.2021', '200');
insert into product(name, type_id, expired_date, price)
values('Рикотта', '2', '19.01.2021', '235');
insert into product(name, type_id, expired_date, price)
values('Пармезан', '2', '27.10.2021', '270');
insert into product(name, type_id, expired_date, price)
values('Пошехонский', '2', '14.02.2021', '250');
insert into product(name, type_id, expired_date, price)
values('Касу марцу', '2', '10.08.2019', '14000');

insert into product(name, type_id, expired_date, price)
values('Пломбир', '3', '12.03.2021', '150');
insert into product(name, type_id, expired_date, price)
values('Молочное и сливочное мороженое', '3', '04.04.2021', '170');
insert into product(name, type_id, expired_date, price)
values('Сорбет', '3', '10.10.2021', '120');
insert into product(name, type_id, expired_date, price)
values('Щербет', '3', '27.05.2021', '160');
insert into product(name, type_id, expired_date, price)
values('Замороженный сок', '3', '21.06.2021', '100');
insert into product(name, type_id, expired_date, price)
values('Акутак', '3', '01.10.2021', '50');

insert into product(name, type_id, expired_date, price)
values('Биойогурт', '4', '28.04.2021', '200');
insert into product(name, type_id, expired_date, price)
values('Греческий йогурт', '4', '20.12.2021', '300');
insert into product(name, type_id, expired_date, price)
values('Питьевой йогурт', '4', '19.07.2021', '290');
insert into product(name, type_id, expired_date, price)
values('Йогурт со свеклой', '4', '11.03.2021', '500');
insert into product(name, type_id, expired_date, price)
values('Йогурт мороженое', '4', '09.10.2021', '100');


select * from product as p 
join type t 
on p.type_id = t.id 
and t.name = 'Сыр';

select * from product as p 
join type t 
on p.type_id = t.id 
and p.name like '%мороженое%';

select * from product as p 
join type t 
on p.type_id = t.id 
and current_date < p.expired_date + interval '6 month';

select max(price) from product;

select t.name, count(p.type_id) 
from type as t 
join product p 
on t.id = p.type_id 
group by t.name;

select * from product as p 
join type t 
on p.type_id = t.id 
and t.name = 'Сыр' 
or t.name = 'Молоко';

select p.name, t.name 
from product as p 
join type t 
on p.type_id = t.id 
and t.name = 'Сыр' 
or t.name = 'Молоко' 
group by p.name, t.name
order by t.name desc;

select t.name, count(p.type_id) 
from type as t 
join product p 
on t.id = p.type_id 
group by t.name 
having count(p.type_id) < 10;

select p.name, t.name 
from product as p 
join type t 
on p.type_id = t.id 
group by p.name, t.name 
order by t.name asc;


