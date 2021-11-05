create table users(
	id serial primary key,
	user_name text
);

create table role(
	id serial primary key,
	role text,
	user_id int references users(id)
);

create table rules(
	id serial primary key,
	rule text
);

create table role_rules(
	id_role int references role(id),
	id_rules int references rules(id)
);

create table category(
	id serial primary key,
	category text
);

create table state(
	id serial primary key,
	state text
);

create table item(
	id serial primary key,
	item text,
	id_user int references users(id),
	id_category int references category(id),
	id_state int references state(id)
);

create table comments(
	id serial primary key,
	comment text,
	id_item int references item(id)
);

create table attachs(
	id serial primary key,
	attach text,
	id_item int references item(id)
);