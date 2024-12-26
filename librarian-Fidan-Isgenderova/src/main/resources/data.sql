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
(name,surname,address,phone,email,username,register_date, librarian_id)
values
('student1','Soyadi','Baki','9826734','student1@mail.ru','student1','2024-10-11 12:13:14', 1),
('student2','Soyadi','Baki','9826734','student2@mail.ru','student2','2024-10-11 12:13:14', 2);

insert into authority_list
(authority,librarian,student)
values
('ROLE_ADD_BOOK',1,0),
('ROLE_GET_BOOK',1,1),
('ROLE_DELETE_BOOK',1,0),
('ROLE_UPDATE_BOOK',1,0),
('ROLE_DELETE_STUDENT', 1, 0),
('ROLE_UPDATE_STUDENT', 1, 0),
('ROLE_GET_STUDENTS_FOR_LIBRARIAN', 1, 0),
('ROLE_GET_ALL_BOOKS', 1, 0);


insert into books
(name,publish_date,register_date,quantity,librarian_id)
values
('Java','2012-11-22','2024-10-11 12:13:14',20,1),
('Css','2012-11-22','2024-10-11 12:13:14',34,1),
('Python','2012-11-22','2024-10-11 12:13:14',22,2);


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