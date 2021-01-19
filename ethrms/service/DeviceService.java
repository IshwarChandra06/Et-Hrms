package tech.eikona.ethrms.service;

import java.util.List;

import tech.eikona.ethrms.entity.Device;

public interface DeviceService {
	
	List<Device> getAll();
    void save(Device device);
    Device getById(long id);
    void deleteById(long id);


}
