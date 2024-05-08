package com.spring.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

private SessionFactory sessionFactory;

Session session;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void addEmployee(Employee p) {
		session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		System.out.println("Employee details saved successfully" +"/n"+p);
	}
	@Override
	public void updateEmployee(Employee p) {
		session = this.sessionFactory.getCurrentSession();
		session.update(p);
		System.out.println("Employee details saved successfully" +"/n"+p);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployees(){
		session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		for(Employee e : employeeList) {
			System.out.println("Employee List ::" + e);
		}
		return employeeList;
	}
	@Override
	public Employee getEmployeeById(int id) {
		session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("removal")
		Employee e = (Employee)session.get(Employee.class, id);
		System.out.println("Employee ::" + e);
		return e;
	}
	@Override
	public void removeEmployee(int id) {
		session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee)session.get(Employee.class, id);
		if(null != e) {
			session.delete(e);
		}
		System.out.println("Employee ::" + e);
	}
}
