create table attachs(
	id serial primary key,
	attach text
);

create table category(
	id serial primary key,
	category text
);

create table comments(
	id serial primary key,
	comment text
);

create table item(
	id serial primary key,
	item text
);

create table role(
	id serial primary key,
	role text
);

create table rules(
	id serial primary key,
	rule text
);

create table state(
	id serial primary key,
	state text
);

create table users(
	id serial primary key,
	user_name text
);