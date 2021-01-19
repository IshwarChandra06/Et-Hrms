package tech.eikona.ethrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.eikona.ethrms.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {

	public List<Designation> findAllByIsDeleteFalse();
}
