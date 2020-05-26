package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	

	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Employee employee = currSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session currSession = entityManager.unwrap(Session.class);
		currSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		Session currSession = entityManager.unwrap(Session.class);
		Employee employee = currSession.get(Employee.class, id);
		currSession.delete(employee);
	}

}
