package tech.eikona.ethrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import tech.eikona.ethrms.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import tech.eikona.ethrms.entity.Organization;
import tech.eikona.ethrms.service.OrganizationService;

@Service
public class OrganizationServiceImp implements OrganizationService {
	
	@Autowired
    private OrganizationRepository organizationRepository;

	@Override
	public List<Organization> getAll() {
		 return organizationRepository.findAllByIsDeletedFalse();
		
	}
	
	@Override
	public void save(Organization organization) {
		organization.setDeleted(false);
        this.organizationRepository.save(organization);
    	
    }
	
	@Override
	public  Organization getById(long id) {
		Optional<Organization> optional = organizationRepository.findById(id);
		Organization organization = null;
        if (optional.isPresent()) {
        	organization = optional.get();
        } else {
            throw new RuntimeException(" Organization not found for id :: " + id);
        }
        return organization;
    	
    }
	
	@Override
	public void deleteById(long id) {
		Optional<Organization> optional = organizationRepository.findById(id);
		Organization department = null;
        if (optional.isPresent()) {
        	department = optional.get();
        	department.setDeleted(true);
        } else {
            throw new RuntimeException(" Department not found for id :: " + id);
        }
        this.organizationRepository.save(department);
	}
    	
}
