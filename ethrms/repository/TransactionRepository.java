package tech.eikona.ethrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.eikona.ethrms.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findByEmpIdOrderByPunchDateStrAscPunchTimeStrAsc(String empId);
	
	List<Transaction> findAllByOrderByPunchDateStrAscPunchTimeStrAsc();
	
	List<Transaction> findByPunchDateStrOrderByPunchDateStrAscPunchTimeStrAsc(String punchDateStr);

	List<Transaction> findByIdGreaterThanOrderByPunchDateStrAscPunchTimeStrAsc(long id);

}
