package com.revature.postgres;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.ComputerGame;
import com.revature.data.ComputerGameDAO;
import com.revature.exceptions.NullFieldException;
import com.revature.utils.ConnectionUtil;

public class ComputerGamePostgres implements ComputerGameDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int create(ComputerGame dataToAdd) throws NullFieldException{
		// TODO Auto-generated method stub
		int generatedID = 0;
		
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO computer_game (id, game_name, description, genre, players, console, status)" + 
							"VALUES (default, ?, ?, ?, ?, ?, ?)";
			String[] keys = {"id"};
			
			PreparedStatement pStmt = conn.prepareStatement(sql,keys);
			pStmt.setString(1, dataToAdd.getGame_name());
			pStmt.setString(2, dataToAdd.getDescription());
			pStmt.setString(3, dataToAdd.getGenre());
			pStmt.setString(4, dataToAdd.getPlayers());
			pStmt.setString(5, dataToAdd.getConsole());
			pStmt.setString(6, dataToAdd.getStatus());
			
			pStmt.executeUpdate();
			ResultSet result = pStmt.getGeneratedKeys();
			
			if(result.next()) {
				generatedID = result.getInt("id");
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedID;
	}

	@Override
	public ComputerGame getByID(int id) {
		// TODO Auto-generated method stub
		ComputerGame game = null;
		
		try (Connection conn = connUtil.getConnection()) {
			String sql = "SELECT * FROM computer_game WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			
			ResultSet result = pStmt.executeQuery();
			
			if(result.next()) {
				game = new ComputerGame(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return game;
	}

	@Override
	public Set<ComputerGame> getAll() {
		// TODO Auto-generated method stub
		Set<ComputerGame> games = new HashSet<>();
		
		try (Connection conn = connUtil.getConnection()) {
			String sql = "SELECT * FROM computer_game";
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next()) {
				ComputerGame game = new ComputerGame(result);
				games.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return games;
	}

	@Override
	public boolean update(ComputerGame dataToUpdate) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "UPDATE computer_game SET game_name=?, description=?, genre=?, "
						+ "players=?, console=?, status=? "
						+ "WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, dataToUpdate.getGame_name());
			pStmt.setString(2, dataToUpdate.getDescription());
			pStmt.setString(3, dataToUpdate.getGenre());
			pStmt.setString(4, dataToUpdate.getPlayers());
			pStmt.setString(5, dataToUpdate.getConsole());
			pStmt.setString(6, dataToUpdate.getStatus());
			pStmt.setInt(7, dataToUpdate.getId());
			
			int rowsAffected = pStmt.executeUpdate();
			
			if (rowsAffected==1) {
				conn.commit();
				isUpdated = true;
			} else {
				conn.rollback();
				isUpdated = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public boolean delete(ComputerGame dataToDelete) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		try (Connection conn  = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "DELETE FROM computer_game WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, dataToDelete.getId());
			
			int rowsAffected = pStmt.executeUpdate();
			if(rowsAffected == 1) {
				conn.commit();
				isDeleted = true;
			} else {
				conn.rollback();
				isDeleted = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public Set<ComputerGame> search(String keyWords) {
		// TODO Auto-generated method stub
		Set<ComputerGame> games = new  HashSet<>();
		
		try (Connection conn = connUtil.getConnection()) {
			String sql = "SELECT * FROM computer_game " + 
							"WHERE game_name LIKE ? OR " + 
							"description LIKE ? OR genre LIKE ? OR " + 
							"players LIKE ? OR console LIKE ? OR " +
							"status LIKE ?";
			
			keyWords = "%" + keyWords + "%";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, keyWords);
			pStmt.setString(2, keyWords);
			pStmt.setString(3, keyWords);
			pStmt.setString(4, keyWords);
			pStmt.setString(5, keyWords);
			pStmt.setString(6, keyWords);

			ResultSet result = pStmt.executeQuery();
			
			while(result.next()) {
				ComputerGame game = new ComputerGame(result);
				games.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return games;
	}

//	@Override
//	public Set<ComputerGame> searchByColumn(String columnName, String keyWords) {
//		// TODO Auto-generated method stub
//		Set<ComputerGame> games = new  HashSet<>();
//		
//		try (Connection conn = connUtil.getConnection()) {
//			String sql = "SELECT * FROM computer_game " + 
//							"WHERE ? LIKE ? ";
//			keyWords = "%" + keyWords + "%";
//			
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, columnName);
//			pStmt.setString(2, keyWords);
//			
//			ResultSet result = pStmt.executeQuery();
//			
//			while(result.next()) {
//				ComputerGame game = new ComputerGame(result);
//				games.add(game);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return games;
//	}

}
