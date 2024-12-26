insert into books
(name,price,publish_date,register_date,quantity,seller_id)
values
('Java',14,'2012-11-22','2024-10-11 12:13:14',20,1),
('Css',24,'2012-11-22','2024-10-11 12:13:14',34,1),
('Python',34,'2012-11-22','2024-10-11 12:13:14',22,2);

insert into sellers
(name,surname,phone,email,address,username,register_date)
values
('Satici1','Soyadi','982673','satici1@mail.ru','Baki','satici1','2024-10-11 12:13:14'),
('Satici2','Soyadi','986673','satici2@mail.ru','Baki','satici2','2024-10-11 12:13:14');


insert into customers
(name,surname,phone,email,address,username,register_date)
values
('Alici1','Soyadi','9826734','alici1@mail.ru','Baki','alici1','2024-10-11 12:13:14'),
('Alici2','Soyadi','9866733','alici2@mail.ru','Baki','alici2','2024-10-11 12:13:14');


insert into users (username, password, enabled) values
('satici1', '{noop}1234', 1),
('satici2', '{noop}1234', 1),
('alici1', '{noop}1234', 1),
('alici2', '{noop}1234', 1);


insert into authority_list
(authority,seller,customer)
values
('ROLE_ADD_BOOK',1,0),
('ROLE_GET_BOOK',1,1),
('ROLE_DELETE_BOOK',1,0),
('ROLE_UPDATE_BOOK',1,0),
('ROLE_ADD_ORDER',0,1),
('ROLE_GET_ORDER_FOR_CUSTOMER',0,1),
('ROLE_GET_ORDER_FOR_SELLER',1,0);

insert into authorities
(username,authority)
select 'satici1',authority
from authority_list where seller=1;

insert into authorities
(username,authority)
select 'satici2',authority
from authority_list where seller=1;

insert into authorities
(username,authority)
select 'alici1',authority
from authority_list where customer=1;

insert into authorities
(username,authority)
select 'alici2',authority
from authority_list where customer=1;

insert into orders
(register_date,total_price,customer_id,seller_id)
values
('2024-10-11 12:13:14',200,1,1),
('2024-10-11 12:13:14',230,2,2);

insert into order_details
(order_id,book_id,quantity)
values
(1,1,3),
(1,2,8),
(2,3,3);