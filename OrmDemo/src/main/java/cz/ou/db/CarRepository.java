package cz.ou.db;

import db.entity.Car;
import db.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarDB");
    EntityManager em;

    public Car getCarById(int id) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Car car = em.find(Car.class, id);
        em.getTransaction().commit();
        em.close();
        return car;
    }

    public List<Car> getAllCars() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Car> cars = em.createNamedQuery("find_all_cars", Car.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return cars;
    }

    public void saveCar(Car car) {
        em = emf.createEntityManager();
        if (car.getId() == null) {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            em.close();
        } else {
            em.getTransaction().begin();
            em.merge(car);
            em.getTransaction().commit();
            em.close();
        }
    }
}
