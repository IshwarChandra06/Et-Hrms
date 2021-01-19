package tech.eikona.ethrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tech.eikona.ethrms.entity.Designation;

import tech.eikona.ethrms.service.DesignationService;

import org.springframework.stereotype.Controller;

@Controller
public class DesignationController {
	@Autowired
	private DesignationService designationService;

	@GetMapping("/designation")
	public String list(Model model) {
		model.addAttribute("Designation", designationService.getAll());
		return "designation/designation_list";
	}

	@GetMapping("/designation/new")
	public String newEntity(Model model) {

		Designation designation = new Designation();
		model.addAttribute("designation", designation);
		return "designation/designation_new";
	}

	@PostMapping("/designation/save")
	public String saveEntity(@ModelAttribute("designation") Designation designation) {

		designationService.save(designation);
		return "redirect:/designation";
	}

	@GetMapping("/designation/update/{id}")
	public String updateEntity(@PathVariable(value = "id") long id, Model model) {

		Designation designation = designationService.getById(id);
		model.addAttribute("designation", designation);
		return "designation/designation_edit";
	}

	@GetMapping("/designation/delete/{id}")
	public String deleteEntity(@PathVariable(value = "id") long id) {

		this.designationService.deleteById(id);
		return "redirect:/designation";
	}

}
