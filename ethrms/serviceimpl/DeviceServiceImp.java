package tech.eikona.ethrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.eikona.ethrms.entity.Device;
import tech.eikona.ethrms.repository.DeviceRepository;
import tech.eikona.ethrms.service.DeviceService;

@Service
public class DeviceServiceImp implements DeviceService {
	
	@Autowired
    private DeviceRepository deviceRepository;

	@Override
	public List<Device> getAll() {
		 return deviceRepository.findAllByIsDeletedFalse();
		
	}
	
	@Override
	public void save(Device device) {
		device.setDeleted(false);
        this.deviceRepository.save(device);
    	
    }
	
	@Override
	public  Device getById(long id) {
		Optional<Device> optional = deviceRepository.findById(id);
		Device device = null;
        if (optional.isPresent()) {
        	device = optional.get();
        } else {
            throw new RuntimeException(" device not found for id :: " + id);
        }
        return device;
    	
    }
	
	@Override
	public void deleteById(long id) {
		Optional<Device> optional = deviceRepository.findById(id);
		Device device = null;
        if (optional.isPresent()) {
        	device = optional.get();
        	device.setDeleted(true);
        } else {
            throw new RuntimeException(" device not found for id :: " + id);
        }
        this.deviceRepository.save(device);
	}

}
