package tech.eikona.ethrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.eikona.ethrms.entity.Department;
import tech.eikona.ethrms.repository.DepartmentRepository;
import tech.eikona.ethrms.service.DepartmentService;

@Service
public class DepartmentServiceImp implements DepartmentService{
	
	@Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List <Department> getAll() {
        return departmentRepository.findAllByIsDeletedFalse();
    }

    @Override
    public void save(Department department) {
    	department.setDeleted(false);
        this.departmentRepository.save(department);
    }

    @Override
    public Department getById(long id) {
        Optional<Department> optional = departmentRepository.findById(id);
        Department department = null;
        if (optional.isPresent()) {
        	department = optional.get();
        } else {
            throw new RuntimeException(" Department not found for id :: " + id);
        }
        return department;
    }
    
    @Override
	public void deleteById(long id) {
    	Optional<Department> optional = departmentRepository.findById(id);
    	Department department = null;
        if (optional.isPresent()) {
        	department = optional.get();
        	department.setDeleted(true);
        } else {
            throw new RuntimeException(" Department not found for id :: " + id);
        }
        this.departmentRepository.save(department);
	}
}
