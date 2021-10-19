create table Person_in_the_hat(
	name_person varchar(150) references person(name),
	hat varchar(150) references hats(hats)
);

