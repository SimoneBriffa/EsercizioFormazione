package com.example.demo.dao;

import com.example.demo.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAO implements DAOGeneralInterface<User>{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        return theQuery.getResultList();

    }

    @Override
    public User save(User user) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(user);

        return user;

    }

    @Override
    public User update(User user) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.update(user);

        return user;

    }

    @Override
    public User findById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(User.class, id);

    }

    @Override
    public void deleteById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        @SuppressWarnings("rawtypes")
        Query theQuery =
                currentSession.createQuery("delete from User where id=:userId");
        theQuery.setParameter("userId", id);

        theQuery.executeUpdate();

    }



    }

