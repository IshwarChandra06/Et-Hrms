package tech.eikona.ethrms.service;

import java.util.List;

import tech.eikona.ethrms.entity.Contractor;

public interface ContractorService {

	List<Contractor> getAll();

	void save(Contractor contractor);

	Contractor getById(long id);

	void deleteById(long id);
}
