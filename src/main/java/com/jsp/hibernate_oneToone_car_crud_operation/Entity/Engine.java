package com.jsp.hibernate_oneToone_car_crud_operation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Engine {
	
	@Id
	private int id;
	private String name;
	

}

