package tech.eikona.ethrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tech.eikona.ethrms.entity.Device;
import tech.eikona.ethrms.service.DeviceService;
import tech.eikona.ethrms.service.OrganizationService;

@Controller
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@GetMapping("/device")
	public String list(Model model) {
		model.addAttribute("listDevice", deviceService.getAll());
		return "device/device_list";
	}

	@GetMapping("/device/add") 
	public String newEntity(Model model) {
	  
		model.addAttribute("listOrganization", organizationService.getAll());
		Device device = new Device(); 
		model.addAttribute("device", device); 
		return "device/device_new"; }

	@PostMapping("/device/save")
	public String save(@ModelAttribute("device") Device device) {
		
		deviceService.save(device);
		return "redirect:/device";
	}

	@GetMapping("/device/edit/{id}")
	public String edit(@PathVariable(value = "id") long id, Model model) {

		model.addAttribute("listOrganization", organizationService.getAll());
		Device device = deviceService.getById(id);
		model.addAttribute("device", device);
		return "device/device_edit";
	}

	@GetMapping("/device/delete/{id}")
	public String delete(@PathVariable(value = "id") long id) {
		this.deviceService.deleteById(id);
		return "redirect:/device";
	}
}
