package tech.eikona.ethrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.eikona.ethrms.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

	List<Device> findAllByIsDeletedFalse();

}
