package com.example.demo.dao;

import com.example.demo.model.Employee;
import com.example.demo.model.Item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO implements DAOGeneralInterface<Employee>{

    @Autowired
    EntityManager entityManager;

    public EmployeeDAO(){

    }
    
    public void requestItem(int employeeId, int itemId) {
    	
    	Session currentSession = entityManager.unwrap(Session.class);
    	
    	Employee employee = currentSession.get(Employee.class, employeeId);
    	Item item = currentSession.get(Item.class, itemId);
    	
    	List<Item> itemsRequested = employee.getItemsRequested();
    	
    	if(itemsRequested == null)
    		itemsRequested = new ArrayList<Item>();
    	
    	itemsRequested.add(item);
    	
    	System.out.println(itemsRequested.size());
    	
    	currentSession.update(employee);
    	
    }

    @Override
    public List<Employee> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;

    }

    @Override
    public Employee update(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.update(employee);

        return employee;

    }

    @Override
    public Employee save(Employee employee) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.save(employee);

        return employee;

    }

    @Override
    public Employee findById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Employee employee = currentSession.get(Employee.class, id);

        return employee;

    }

    @Override
    public void deleteById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        @SuppressWarnings("rawtypes")
		Query theQuery =
                currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);

        theQuery.executeUpdate();

    }
}
