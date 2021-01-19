package tech.eikona.ethrms.service;

import java.util.List;

import tech.eikona.ethrms.entity.Department;


public interface DepartmentService {
	
	List<Department> getAll();
    void save(Department department);
    Department getById(long id);
    void deleteById(long id);    

}
