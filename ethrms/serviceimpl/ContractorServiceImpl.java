package tech.eikona.ethrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.eikona.ethrms.entity.Contractor;
import tech.eikona.ethrms.repository.ContractorRepository;
import tech.eikona.ethrms.service.ContractorService;

@Service
public class ContractorServiceImpl implements ContractorService {

	@Autowired
	private ContractorRepository contractorRepository;

	@Override
	public List<Contractor> getAll() {
		return contractorRepository.findAllByIsDeleteFalse();
	}

	@Override
	public void save(Contractor contractor) {
		contractor.setDelete(false);
		this.contractorRepository.save(contractor);
	}

	@Override
	public Contractor getById(long id) {
		Optional<Contractor> optional = contractorRepository.findById(id);
		Contractor contractor = null;
		if (optional.isPresent()) {
			contractor = optional.get();
		} else {
			throw new RuntimeException(" Contractor not found for id :: " + id);
		}
		return contractor;
	}

	@Override
	public void deleteById(long id) {
		Optional<Contractor> optional = contractorRepository.findById(id);
		Contractor contractor = null;
		if (optional.isPresent()) {
			contractor = optional.get();
			contractor.setDelete(true);
		} else {
			throw new RuntimeException(" Contractor not found for id :: " + id);
		}
		this.contractorRepository.save(contractor);
	}

}
