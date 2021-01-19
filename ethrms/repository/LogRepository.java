package tech.eikona.ethrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.eikona.ethrms.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
