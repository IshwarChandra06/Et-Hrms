package tech.eikona.ethrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tech.eikona.ethrms.entity.Department;
import tech.eikona.ethrms.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/department")
	public String list(Model model) {
		model.addAttribute("listDepartment", departmentService.getAll());
		return "department/department_list";
	}

	@GetMapping("/department/add") 
	public String newEntity(Model model) {
	  
		Department department = new Department(); 
		model.addAttribute("department", department); 
		return "department/department_new"; }

	@PostMapping("/department/save")
	public String save(@ModelAttribute("department") Department department) {

		departmentService.save(department);
		return "redirect:/department";
	}

	@GetMapping("/department/edit/{id}")
	public String edit(@PathVariable(value = "id") long id, Model model) {

		Department department = departmentService.getById(id);
		model.addAttribute("department", department);
		return "department/department_edit";
	}

	@GetMapping("/department/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		this.departmentService.deleteById(id);
		return "redirect:/department";
	}

}
