package tech.eikona.ethrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.eikona.ethrms.entity.Contractor;


@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
	public List<Contractor> findAllByIsDeleteFalse();
}
