package tech.eikona.ethrms.service;

import java.util.List;

import tech.eikona.ethrms.entity.Organization;

public interface OrganizationService {
	
	List<Organization> getAll();
    void save(Organization organization);
    Organization getById(long id);
    void deleteById(long id);

}
