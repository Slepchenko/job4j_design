CREATE TABLE company(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values('1', 'company_1');
insert into company(id, name) values('2', 'company_2');
insert into company(id, name) values('3', 'company_3');
insert into company(id, name) values('4', 'company_4');
insert into company(id, name) values('5', 'company_5');
insert into company(id, name) values('6', 'company_6');

insert into person(id, name, company_id) values('1', 'person_1', '1');
insert into person(id, name, company_id) values('2', 'person_2', '4');
insert into person(id, name, company_id) values('3', 'person_3', '5');
insert into person(id, name, company_id) values('4', 'person_4', '4');
insert into person(id, name, company_id) values('5', 'person_5', '3');
insert into person(id, name, company_id) values('6', 'person_6', '6');
insert into person(id, name, company_id) values('7', 'person_7', '2');
insert into person(id, name, company_id) values('8', 'person_8', '5');
insert into person(id, name, company_id) values('9', 'person_9', '2');
insert into person(id, name, company_id) values('10', 'person_10', '6');

select p.name, c.name
from person p
join company c on c.id = p.company_id
where p.company_id != 5
		
select c.name, count(p.company_id)
from person p
join company c on p.company_id = c.id
group by c.name
having count(p.company_id) = 
		(select count(p.company_id) as quantity
		from person p
		group by company_id
	    order by quantity desc
	    limit 1)