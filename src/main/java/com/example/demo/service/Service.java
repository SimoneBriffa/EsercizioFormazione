package com.example.demo.service;

import java.util.List;

public interface Service<Entity> {

    public List<Entity> getAll();

    public Entity read(int id);

    public Entity insert (Entity dto);

    public Entity update (Entity dto);

    public void delete (int id);


}
