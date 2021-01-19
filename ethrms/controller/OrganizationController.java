package tech.eikona.ethrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tech.eikona.ethrms.entity.Department;
import tech.eikona.ethrms.entity.Organization;
import tech.eikona.ethrms.service.DepartmentService;
import tech.eikona.ethrms.service.OrganizationService;

@Controller
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;

	@GetMapping("/organization")
	public String list(Model model) {
		model.addAttribute("listOrganization", organizationService.getAll());
		return "organization/organization_list";
	}

	@GetMapping("/organization/add") 
	public String newEntity(Model model) {
	  
		Organization organization = new Organization(); 
		model.addAttribute("organization", organization); 
		return "organization/organization_new"; }

	@PostMapping("/organization/save")
	public String save(@ModelAttribute("organization") Organization organization) {

		organizationService.save(organization);
		return "redirect:/organization";
	}

	@GetMapping("/organization/edit/{id}")
	public String edit(@PathVariable(value = "id") long id, Model model) {

		Organization organization = organizationService.getById(id);
		model.addAttribute("organization", organization);
		return "organization/orginazatio_edit";
	}

	@GetMapping("/organization/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		this.organizationService.deleteById(id);
		return "redirect:/organization";
	}

}
