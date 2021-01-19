package tech.eikona.ethrms.service;

import java.util.List;

import tech.eikona.ethrms.entity.Designation;

public interface DesignationService {

	List<Designation> getAll();

	void save(Designation designation);

	Designation getById(long id);

	void deleteById(long id);
}
