package tech.eikona.ethrms.service;

import java.util.List;

import tech.eikona.ethrms.entity.Shift;



public interface ShiftService 
{

	List<Shift> getAll();

	void save(Shift shift);

	Shift getById(long id);

	void deleteById(long id);
}
