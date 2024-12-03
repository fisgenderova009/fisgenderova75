insert into authority_list
(authority,librarian,student)
values
('ROLE_ADD_BOOK',1,0),
('ROLE_GET_BOOK',1,1),
('ROLE_DELETE_BOOK',1,0),
('ROLE_UPDATE_BOOK',1,0);

insert into users
(username,password,enabled)
values
('librarian1','{noop}1234',1),
('librarian2','{noop}1234',1),
('student1','{noop}1234',1),
('student2','{noop}1234',1);

insert into librarians
(name,surname,address,phone,email,username,register_date)
values
('librarian1','Soyadi','Baki','9826734','librarian1@mail.ru','librarian1','2024-10-11 12:13:14'),
('librarian2','Soyadi','Baki','9826734','librarian2@mail.ru','librarian2','2024-10-11 12:13:14');

insert into students
(name,surname,address,phone,email,username,register_date)
values
('student1','Soyadi','Baki','9826734','student1@mail.ru','student1','2024-10-11 12:13:14'),
('student2','Soyadi','Baki','9826734','student2@mail.ru','student2','2024-10-11 12:13:14');


insert into authorities
(username,authority)
select 'librarian1',authority
from authority_list where librarian=1;

insert into authorities
(username,authority)
select 'librarian2',authority
from authority_list where librarian=1;

insert into authorities
(username,authority)
select 'student1',authority
from authority_list where student=1;

insert into authorities
(username,authority)
select 'student2',authority
from authority_list where student=1;