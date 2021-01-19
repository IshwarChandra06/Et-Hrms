package tech.eikona.ethrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.eikona.ethrms.entity.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
	public List<Shift> findAllByIsDeleteFalse();

}
