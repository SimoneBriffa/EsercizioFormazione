package com.example.demo.service;

import com.example.demo.dao.DAOGeneralInterface;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractService<Entity> implements Service<Entity> {

    @Autowired
    protected DAOGeneralInterface<Entity> repository;

    @Override
    @Transactional
    public Entity insert(Entity entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public List<Entity> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Entity read(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Entity update(Entity entity) {
        return repository.update(entity);
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }


}
