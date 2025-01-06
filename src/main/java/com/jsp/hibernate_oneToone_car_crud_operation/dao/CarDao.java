package com.jsp.hibernate_oneToone_car_crud_operation.dao;

import com.jsp.hibernate_oneToone_car_crud_operation.Entity.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CarDao {
	EntityManager em=Persistence.createEntityManagerFactory("hibernate-a5").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Car saveCar(Car car) {
		try {
			et.begin();
			em.persist(car);
			//em.persist(engine);
			//Calling persist on both Car and Engine ensures both are saved, 
			//but persisting engine separately may not be required if cascade persist is configured.
			et.commit();
			return car;
		
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int removeCarData(int id){
		try {
			
			Car car=em.find(Car.class,id);
			
			et.begin();
			if(car!=null)
				em.remove(car);
			et.commit();				
			return 1;
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			return 0;			
		}
	}

	public void displayCarById(int id) {
		
		 Car car=em.find(Car.class, id);
		 if(car!=null)
			 System.out.println(car);
		 else
			 System.out.println("no such id");;
	}
	
	
	public void displayAllCars() {
		em.createQuery("from Car").getResultList().forEach(car->System.out.println(car));
		
	}
	

	
	
}
