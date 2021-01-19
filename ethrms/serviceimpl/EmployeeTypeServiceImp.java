package tech.eikona.ethrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.eikona.ethrms.entity.EmployeeType;
import tech.eikona.ethrms.repository.EmployeeTypeRepository;
import tech.eikona.ethrms.service.EmployeeTypeService;

@Service
public class EmployeeTypeServiceImp implements EmployeeTypeService {
	
	@Autowired
    private EmployeeTypeRepository employeeTypeRepository;

	@Override
	public List<EmployeeType> getAll() {
		 return employeeTypeRepository.findAllByIsDeletedFalse();
		
	}
	
	@Override
	public void save(EmployeeType employeeType) {
		employeeType.setDeleted(false);
        this.employeeTypeRepository.save(employeeType);
    	
    }
	
	@Override
	public  EmployeeType getById(long id) {
		Optional<EmployeeType> optional = employeeTypeRepository.findById(id);
		EmployeeType employeeType = null;
        if (optional.isPresent()) {
        	employeeType = optional.get();
        } 
        else {
            throw new RuntimeException("Employee Type not found for id :: " + id);
        }
        return employeeType;
    	
    }
	
	@Override
	public void deleteById(long id) {
		Optional<EmployeeType> optional = employeeTypeRepository.findById(id);
		EmployeeType employeeType = null;
        if (optional.isPresent()) {
        	employeeType = optional.get();
        	employeeType.setDeleted(true);
        } 
        else {
            throw new RuntimeException(" device not found for id :: " + id);
        }
        this.employeeTypeRepository.save(employeeType);
	}


}
