package com.rcpfc.base;

public interface BaseDAO<T>
{
	public void save(T object);

	public void update(T object);
	
	public void insertOrUpdate(T object);
}
