package com.revature.data;

import com.revature.beans.ComputerGame;
import com.revature.postgres.ComputerGamePostgres;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class ComputerGameDAOTest {
	private ComputerGameDAO gameDAO = new ComputerGamePostgres();
//	private int generatedID = 0;
	
	
	@Test
	public void getAllNotNull() {
//		fail("Not Implemented");
		Set<ComputerGame> actual = this.gameDAO.getAll();
		assertNotNull(actual);
	}
	
	@Test
	public void getComputerGameByID() {
//		fail("Not Implemented");
		String game_name = "Dota 2";
		ComputerGame game = gameDAO.getByID(1);
		assertEquals(game_name, game.getGame_name());
	}
	
	@Test
	public void UpdateTest() {
//		fail("Not Implemented");
		boolean isUpdated;
		ComputerGame game = gameDAO.getByID(1);
		game.setGame_name("Dota 2");
		isUpdated = gameDAO.update(game);
		assertTrue(isUpdated);
	}
	
}
