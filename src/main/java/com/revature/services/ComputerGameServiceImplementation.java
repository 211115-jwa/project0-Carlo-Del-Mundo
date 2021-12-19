package com.revature.services;

import java.util.*;

import com.revature.beans.ComputerGame;
import com.revature.data.ComputerGameDAO;
import com.revature.exceptions.NullFieldException;
import com.revature.postgres.ComputerGamePostgres;

public class ComputerGameServiceImplementation implements ComputerGameService{
	private ComputerGameDAO gameDAO = new ComputerGamePostgres();

	@Override
	public Set<ComputerGame> search(String keyWord) {
		// TODO Auto-generated method stub
		Set<ComputerGame> games = gameDAO.search(keyWord);
		return games;
	}

	@Override
	public int create(ComputerGame dataToAdd) throws NullFieldException{
		// TODO Auto-generated method stub
		try {
			validateGameFields(dataToAdd);
		} catch (NullFieldException e) {
			throw new NullFieldException(e.getMessage());
		}

		return gameDAO.create(dataToAdd);
	}

	@Override
	public ComputerGame getByID(int id) {
		// TODO Auto-generated method stub 
		return gameDAO.getByID(id);
	}
	
	@Override
	public Set<ComputerGame> getAll() {
		// TODO Auto-generated method stub
		return gameDAO.getAll();
	}

	@Override
	public boolean update(ComputerGame dataToUpdate) {
		// TODO Auto-generated method stub
		return gameDAO.update(dataToUpdate);
	}

	@Override
	public boolean delete(ComputerGame dataToDelete) {
		// TODO Auto-generated method stub
		return gameDAO.delete(dataToDelete);
	}
	
	@Override
	public ComputerGame validateGameFields(ComputerGame input) throws NullFieldException{
//		input.setGame_name(((input.getGame_name() == null) ? "" : input.getGame_name()));
		
		if(input.getGame_name() == null) {
			throw new NullFieldException("Game_name cannot be null.");
		}
		if(input.getDescription() == null) {
			throw new NullFieldException("Description cannot be null.");
		}
		if(input.getGenre() == null) {
			throw new NullFieldException("Genre cannot be null.");
		}
		if(input.getPlayers() == null) {
			throw new NullFieldException("Players cannot be null.");
		}
		if(input.getConsole() == null) {
			throw new NullFieldException("Console cannot be null.");
		}
		if(input.getStatus() == null) {
			throw new NullFieldException("Status cannot be null.");
		}
		
		return input;
	}
	
//	@Override
//	public Set<ComputerGame> searchByColumn(String columnName, String keyWord) {
//		// TODO Auto-generated method stub
//		Set<ComputerGame> games = gameDAO.searchByColumn(columnName,keyWord);
//		return games;
//	}
}
