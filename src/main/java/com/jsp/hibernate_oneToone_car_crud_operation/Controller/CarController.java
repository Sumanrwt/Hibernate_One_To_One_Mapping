package com.jsp.hibernate_oneToone_car_crud_operation.Controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_oneToone_car_crud_operation.Entity.Car;
import com.jsp.hibernate_oneToone_car_crud_operation.Entity.Engine;
import com.jsp.hibernate_oneToone_car_crud_operation.dao.CarDao;
import com.jsp.hibernate_oneToone_car_crud_operation.dao.EngineDao;


public class CarController {
	public static void main(String[] args) {

		CarDao carDao = new CarDao();
		EngineDao engineDao=new EngineDao();
			
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Your Choice\n1. Add a Car\n2. Add a Engine \n3. Delete the car\n4. Delete the engine\n5. Display car by carId\n6. Display engine by carId\n7. "
					+ "Display engine and car by Engine id\n8. Display All records\n9. exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter car Id");
				int id = sc.nextInt();
				System.out.println("Enter car name");
				String name=sc.next();
				System.out.println("Enter car color");
				String color=sc.next();
				System.out.println("Enter car price");
				double price=sc.nextDouble();
				System.out.println("Enter Engine Id");
				int engine_id = sc.nextInt();
				System.out.println("Enter engine name");
				String engine_name=sc.next();
				Engine engine=new Engine(engine_id,engine_name);
				Car car=carDao.saveCar(new Car(id,name,color,price,engine));
				
				String msg=(car!=null?"Car Succesfully save with Engine Data":"Something Went Wrong");
				System.out.println(msg);
				}
			break;
			case 2:{
				System.out.println("Enter Engine Id");
				int engine_id = sc.nextInt();
				System.out.println("Enter engine name");
				String engine_name=sc.next();
				Engine engine=engineDao.saveEngine(new Engine(engine_id,engine_name));
				String msg=(engine!=null?"Engine Data successfully saved":"Something Went Wrong");
				System.out.println(msg);
			}
			break;
			case 3:{
				System.out.println("Enter Car Id");
				int id = sc.nextInt();
				int res=carDao.removeCarData(id);
				String msg=(res!=0?"Car Data successfully Deleted":"Something Went Wrong");
				System.out.println(msg);
				}
			break;
			case 4:{
				System.out.println("Enter Car Id");
				int id = sc.nextInt();
				int res=engineDao.removeEngineData(id);
				String msg=(res!=0?"Engine Data successfully Deleted":"Something Went Wrong");
				System.out.println(msg);
				
			}break;
			case 5:{
				System.out.println("Enter Car Id");
				int id = sc.nextInt();
				carDao.displayCarById(id);
			}break;
			case 6:{
				System.out.println("Enter Car Id");
				int id = sc.nextInt();
				engineDao.displayEngineByCarId(id);
			}break;
			case 7:{
				System.out.println("Enter Engine Id");
				int id = sc.nextInt();
				engineDao.displayEngineCarByEngineId(id);
				}break;
			case 8:{
				carDao.displayAllCars();
			}break;
			case 9:{
				System.out.println("exit from program");
				return;
			}
			
			}
		}

	}

}
