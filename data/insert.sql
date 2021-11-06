insert into users(id, user_name, role_id) values('1', 'user_1', '2');
insert into users(id, user_name, role_id) values('2', 'user_2', '3');
insert into users(id, user_name, role_id) values('3', 'user_3', '1');

insert into role(id, role, user_id) values('1', 'role_1', '2');
insert into role(id, role, user_id) values('2', 'role_2', '1');
insert into role(id, role, user_id) values('3', 'role_3', '1');
insert into role(id, role, user_id) values('4', 'role_4', '3');

insert into rules(id, rule) values('1', 'rule_1');
insert into rules(id, rule) values('2', 'rule_2');
insert into rules(id, rule) values('3', 'rule_3');

insert into role_rules(id_role, id_rules) values ('1', '3');
insert into role_rules(id_role, id_rules) values ('3', '2');
insert into role_rules(id_role, id_rules) values ('2', '1');
insert into role_rules(id_role, id_rules) values ('3', '3');

insert into category(id, category) values ('1', 'category_1');
insert into category(id, category) values ('2', 'category_2');
insert into category(id, category) values ('3', 'category_3');

insert into state(id, state) values ('1', 'state_1');
insert into state(id, state) values ('2', 'state_2');
insert into state(id, state) values ('3', 'state_3');

insert into item(id, item, id_user, id_category, id_state) values('1', 'item_1', 2, 1, 3);
insert into item(id, item, id_user, id_category, id_state) values('2', 'item_2', 1, 2, 3);
insert into item(id, item, id_user, id_category, id_state) values('3', 'item_3', 3, 1, 3);
insert into item(id, item, id_user, id_category, id_state) values('4', 'item_4', 1, 1, 1);
insert into item(id, item, id_user, id_category, id_state) values('5', 'item_5', 2, 2, 3);

insert into comments(id, comment, id_item) values('1', 'comment_1', '2');
insert into comments(id, comment, id_item) values('2', 'comment_1', '1');
insert into comments(id, comment, id_item) values('3', 'comment_1', '1');

insert into attachs(id, attach, id_item) values('1', 'attach_1', '3');
insert into attachs(id, attach, id_item) values('2', 'attach_2', '2');
insert into attachs(id, attach, id_item) values('3', 'attach_3', '3');