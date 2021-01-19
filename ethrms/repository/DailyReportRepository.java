package tech.eikona.ethrms.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.eikona.ethrms.entity.DailyReport;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Long>{
	
	
	DailyReport findByEmpIdAndDate(String empId, Date Date);

	List<DailyReport> findByIdGreaterThan(Long id);

	List<DailyReport> findAllByOrderByDate();
	
}
