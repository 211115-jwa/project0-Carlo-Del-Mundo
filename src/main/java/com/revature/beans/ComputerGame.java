package com.revature.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ComputerGame {
	private int id;
	private String game_name;
	private String description;
	private String genre;
	private String players;
	private String console;
	private String status;
	
	public ComputerGame() {
		this(0,"","","","","","");
	}
	
	public ComputerGame(ResultSet row) throws SQLException {
		this(row.getInt("id"), 
				row.getString("game_name"), 
				row.getString("description"), 
				row.getString("genre"), 
				row.getString("players"), 
				row.getString("console"), 
				row.getString("status"));
	}
	
	public ComputerGame(int id, String game_name, String description, String genre, String players, String console, String status) {
		this.id = id;
		this.game_name = game_name;
		this.description = description;
		this.genre = genre;
		this.players = players;
		this.console = console;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(console, description, game_name, genre, id, players, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ComputerGame)) {
			return false;
		}
		ComputerGame other = (ComputerGame) obj;
		return Objects.equals(console, other.console) && Objects.equals(description, other.description)
				&& Objects.equals(game_name, other.game_name) && Objects.equals(genre, other.genre) && id == other.id
				&& Objects.equals(players, other.players) && Objects.equals(status, other.status);
	}

	
	
}
