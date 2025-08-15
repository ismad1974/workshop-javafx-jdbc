package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
	
	public List<Department> findAll(){
		List<Department> list=new ArrayList<>();
		list.add(new Department(1,"Livros"));
		list.add(new Department(2,"Informatica"));
		list.add(new Department(3,"Eletricos"));
		list.add(new Department(4,"Eletronics"));
		list.add(new Department(5,"Cama & Mesa"));
		list.add(new Department(6,"Utensílios"));
		list.add(new Department(7,"Celulares"));
		list.add(new Department(8,"Alimentos"));
		
		return list;
		
	}

}
