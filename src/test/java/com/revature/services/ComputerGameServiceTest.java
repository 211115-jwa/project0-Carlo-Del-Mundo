package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.ComputerGame;
import com.revature.data.ComputerGameDAO;
import com.revature.exceptions.NullFieldException;

@ExtendWith(MockitoExtension.class)
public class ComputerGameServiceTest {
	private static Set<ComputerGame> mockGames;
	private static Set<ComputerGame> mockGamesEmpty;
	private static NullFieldException mockException;
	
	@Mock
	private ComputerGameDAO mockGameDAO;
	
	@InjectMocks
	private ComputerGameService gameServ = new ComputerGameServiceImplementation();
	
	@BeforeAll
	private static void mockGamesSetup() {
		mockGames = new HashSet<>();
		mockGamesEmpty = new HashSet<>();
		mockException = new NullFieldException("game_name is null");
		
		for(int i=1;i<=5;i++) {
			ComputerGame game = new ComputerGame(i,"Test"+i,"Test"+i,"Test"+i,"Test"+i,"Test"+i,"Test"+i);
			mockGames.add(game);
		}
	}
	
	@Test
	public void searchAllColumnsTestNotEmpty() {
//		fail("Not Implemented");
		String keyWord = "Test";
		when(mockGameDAO.search(keyWord)).thenReturn(mockGames);
		
		Set<ComputerGame> actual = gameServ.search(keyWord);
		assertEquals(mockGames, actual);
	}

	@Test
	public void searchAllColumnsTestEmpty() {
//		fail("Not Implemented");
		String keyWord = "Test";
		when(mockGameDAO.search(keyWord)).thenReturn(mockGamesEmpty);
		
		Set<ComputerGame> actual = gameServ.search(keyWord);
		assertTrue(actual.size() == 0);
	}
	
	@Test
	public void nullFieldExceptionTest() throws NullFieldException {
//		fail("Not Implemented");
		ComputerGame game = new ComputerGame();
		game.setId(1);
		game.setGame_name(null);
		game.setDescription(null);
		
		assertThrows(NullFieldException.class, () -> {
			gameServ.validateGameFields(game);
		});
	}

//	@Test
//	public void searchByColumnEmpty() {
////		fail("Not Implemented");
//		String keyWord = "No result";
//		String columnName = "game_name";
//		when(mockGameDAO.searchByColumn(columnName,keyWord)).thenReturn(mockGamesEmpty);
//		
//		Set<ComputerGame> actual = gameServ.searchByColumn(columnName,keyWord);
//		assertFalse(actual.size() > 0);
//	}

//	@Test
//	public void searchByColumnNotEmpty() {
////		fail("Not Implemented");
//		String keyWord = "Test";
//		String columnName = "game_name";
//		when(mockGameDAO.searchByColumn(columnName,keyWord)).thenReturn(mockGames);
//		
//		Set<ComputerGame> actual = gameServ.searchByColumn(columnName,keyWord);
//		assertEquals(mockGames, actual);
//	}
}
