package com.revature.services;

import java.util.Set;

import com.revature.beans.ComputerGame;
import com.revature.data.GenericDAO;
import com.revature.exceptions.NullFieldException;

public interface ComputerGameService extends GenericDAO<ComputerGame> {
	public Set<ComputerGame> search(String keyWord);
	public ComputerGame validateGameFields(ComputerGame input) throws NullFieldException;
//	public Set<ComputerGame> searchByColumn(String columnName,String game_name);
}
