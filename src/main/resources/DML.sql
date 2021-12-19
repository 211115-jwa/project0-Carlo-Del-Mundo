insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'Dota 2', 'Defense Of The Ancients 2', 'RPG, Cooperative', 'Multiplayer', 'PC', 'Available');
	
insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'CSGO', 'Counter Strike Global Offensive', 'Action, Cooperative', 'Multiplayer', 'PC', 'Available');
	
insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'PUBG', 'Player Unknown Battle Ground', 'Battle Royale', 'multiplayer', 'PC', 'Updating');
	
insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'Assasin''s Creed', 'Valhalla', 'Adventure, Action', 'Single Player', 'XBox', 'Available');
	
insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'Galaga', 'Pew pew pew', 'Adventure', 'Single Player', 'Arcade', 'Broken');
	
insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'Red Alert III', 'Yuri''s Revenge', 'Cooperative', 'Multiplayer', 'PC', 'Available');
	
insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'Call Of Duty', 'Warzone', 'Cooperative', 'Multiplayer', 'PC', 'Available');
insert into computer_game (id, game_name, description, genre, players, console, status)
	values (default,'Call Of Duty', 'Vanguard', 'Cooperative', 'Multiplayer', 'XBox', 'Available');

update project0.computer_game
set game_name='PUBG', description='Player Unknown Battle Ground', genre='Battle Royale', players='multiplayer', console='PC', status='Available'
where id=3;