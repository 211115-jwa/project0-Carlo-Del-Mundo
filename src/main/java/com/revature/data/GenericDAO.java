package com.revature.data;

import java.util.Set;

import com.revature.exceptions.NullFieldException;

public interface GenericDAO<D> {
	public int create(D dataToAdd) throws NullFieldException;
	public D getByID(int id);
	public Set<D> getAll();
	public boolean update(D dataToUpdate);
	public boolean delete(D dataToDelete);
	public Set<D> search(String keyWords);
}
