package tech.eikona.ethrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.eikona.ethrms.entity.Designation;
import tech.eikona.ethrms.repository.DesignationRepository;

import tech.eikona.ethrms.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepository designationRepository;

	@Override
	public List<Designation> getAll() {
		return designationRepository.findAllByIsDeleteFalse();
	}

	@Override
	public void save(Designation designation) {
		designation.setDelete(false);
		this.designationRepository.save(designation);
	}

	@Override
	public Designation getById(long id) {
		Optional<Designation> optional = designationRepository.findById(id);
		Designation designation = null;
		if (optional.isPresent()) {
			designation = optional.get();
		} else {
			throw new RuntimeException(" Designation not found for id :: " + id);
		}
		return designation;
	}

	@Override
	public void deleteById(long id) {
		Optional<Designation> optional = designationRepository.findById(id);
		Designation designation = null;
		if (optional.isPresent()) {
			designation = optional.get();
			designation.setDelete(true);
		} else {
			throw new RuntimeException(" Designation not found for id :: " + id);
		}
		this.designationRepository.save(designation);
	}

}
