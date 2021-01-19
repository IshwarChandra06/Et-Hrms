package tech.eikona.ethrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tech.eikona.ethrms.entity.EmployeeType;
import tech.eikona.ethrms.service.EmployeeTypeService;

@Controller
public class EmployeeTypeController {
	@Autowired
	private EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeeType")
	public String list(Model model) {
		model.addAttribute("listEmployeeType", employeeTypeService.getAll());
		return "employee_type/employee_type_list";
	}

	@GetMapping("/employeeType/add") 
	public String newEntity(Model model) {
	  
		EmployeeType employeeType = new EmployeeType(); 
		model.addAttribute("employeeType", employeeType); 
		return "employee_type/employee_type_new"; }

	@PostMapping("/employeeType/save")
	public String save(@ModelAttribute("employeeType") EmployeeType employeeType) {
		
		employeeTypeService.save(employeeType);
		return "redirect:/employeeType";
	}

	@GetMapping("/employeeType/edit/{id}")
	public String edit(@PathVariable(value = "id") long id, Model model) {

		EmployeeType employeeType = employeeTypeService.getById(id);
		model.addAttribute("employeeType", employeeType);
		return "employee_type/employee_type_edit";
	}

	@GetMapping("/employeeType/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		this.employeeTypeService.deleteById(id);
		return "redirect:/employeeType";
	}

}
