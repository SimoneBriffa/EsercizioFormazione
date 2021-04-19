package com.example.demo.dao;

import java.util.List;

public interface DAOGeneralInterface<Entity> {
	
	public List<Entity> findAll();
	
	public Entity save(Entity entity);
	
	public Entity findById(int id);
	
	public Entity update(Entity entity);
	
	public void deleteById(int id);
	

}
