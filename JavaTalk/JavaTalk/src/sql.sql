create table user(
	count int auto_increment primary key,
	id varchar(100) not null,
	password varchar(250) not null,
	nick_name varchar(100) not null
);

create table friends(
	user_id int,
	friend_id int,
	PRIMARY KEY (user_id, friend_id),
    FOREIGN KEY (user_id) REFERENCES user(count),
    FOREIGN KEY (friend_id) REFERENCES user(count)
);
