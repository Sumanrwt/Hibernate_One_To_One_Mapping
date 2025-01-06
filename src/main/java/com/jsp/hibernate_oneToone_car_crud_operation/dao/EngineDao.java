package com.jsp.hibernate_oneToone_car_crud_operation.dao;

import com.jsp.hibernate_oneToone_car_crud_operation.Entity.Car;
import com.jsp.hibernate_oneToone_car_crud_operation.Entity.Engine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class EngineDao {
	EntityManager em=Persistence.createEntityManagerFactory("hibernate-a5").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Engine saveEngine(Engine engine) {
		try {
			et.begin();
			em.persist(engine);
			
			et.commit();
			return engine;
		
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public int removeEngineData(int id) {
		try {
			Car car=em.find(Car.class, id);
			Engine engine=car.getEngine();
			
			if(engine!=null) {
				et.begin();
				car.setEngine(null);
				em.merge(car);
				em.remove(engine);
				et.commit();}
			
			return 1;			
			
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			return 0;
			
		}
	}
	
	


	public void displayEngineByCarId(int id) {
		
		 Car car=em.find(Car.class, id);
		 Engine engine=car.getEngine();
		 if(car!=null)
			 System.out.println(engine);
		 else
			 System.out.println("no such engine associated with this car id");
	}
	
	
	public void displayEngineCarByEngineId(int id) {
		String fetchCarbyEngineId="select c from Car c where c.engine.id=:engineId";
		Query query=em.createQuery(fetchCarbyEngineId);
		Car car=(Car) query.setParameter("engineId", id).getSingleResult();
		if(car!=null) {
			System.out.println("car details");
			System.out.println("car id: "+car.getCarId()+"\ncar name:"+car.getCarName()+"\ncar color:"+car.getColor()+"\ncar price:"+car.getPrice());
			Engine engine=car.getEngine();
			System.out.println("Engine Details");
			System.out.println("Engine Id: "+engine.getId()+"\nEngine name: "+engine.getName());
		}
		else
			System.out.println("no such car and engine associated with this id");
	}
}
