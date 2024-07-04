create table user(
	count int auto_increment primary key,
	id varchar(100) not null,
	password varchar(250) not null,
	nick_name varchar(100) not null
);