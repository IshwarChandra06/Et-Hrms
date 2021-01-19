package tech.eikona.ethrms.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.eikona.ethrms.entity.Shift;
import tech.eikona.ethrms.repository.ShiftRepository;
import tech.eikona.ethrms.service.ShiftService;

@Service
public class ShiftServiceImpl implements ShiftService {

	@Autowired
	private ShiftRepository shiftRepository;

	@Override
	public List<Shift> getAll() {
		return shiftRepository.findAllByIsDeleteFalse();
	}

	@Override
	public void save(Shift shift) {
		shift.setDelete(false);
		this.shiftRepository.save(shift);
	}

	@Override
	public Shift getById(long id) {
		Optional<Shift> optional = shiftRepository.findById(id);
		Shift shift = null;
		if (optional.isPresent()) {
			shift = optional.get();
		} else {
			throw new RuntimeException("Shift not found for id :: " + id);
		}
		return shift;
	}

	@Override
	public void deleteById(long id) {
		Optional<Shift> optional = shiftRepository.findById(id);
		Shift shift = null;
		if (optional.isPresent()) {
			shift = optional.get();
			shift.setDelete(true);
		} else {
			throw new RuntimeException(" Shift not found for id :: " + id);
		}
		this.shiftRepository.save(shift);
	}

}

