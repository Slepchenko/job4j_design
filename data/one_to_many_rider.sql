create table rider(
	horse text,
	name_owner text references person(name)
);