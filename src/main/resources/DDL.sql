create table project0.computer_game (
	id serial primary key,
	game_name varchar(300) not null,
	description varchar(500) not null,
	genre varchar(50) not null,
	players varchar(50) not null,
	console varchar(30) not null,
	status varchar(20) not null
);