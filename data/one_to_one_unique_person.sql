create table unique_person2(
	type_people varchar(100) references personality(type_people),
	name_unipue_person varchar(100) references person(name)
);