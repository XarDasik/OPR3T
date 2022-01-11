package cz.ou.db;

import db.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeRepository{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarDB");
    EntityManager em;
    public Employee getEmployeeById(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);
        em.getTransaction().commit();
        em.close();
        return employee;
    }

    public List<Employee> getAllEmployees() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Employee> employee = em.createNamedQuery("find_all_employees", Employee.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return employee;
    }

    public void saveEmployee(Employee employee) {
        em = emf.createEntityManager();
        if(employee.getId() == null){
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            em.close();
        }
        else{
            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();
            em.close();
        }


    }
}
