package tech.eikona.ethrms.service;

import java.util.List;

import tech.eikona.ethrms.entity.EmployeeType;

public interface EmployeeTypeService {
	
	List<EmployeeType> getAll();
    void save(EmployeeType employeeType);
    EmployeeType getById(long id);
    void deleteById(long id);

}
