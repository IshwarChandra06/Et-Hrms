package tech.eikona.ethrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tech.eikona.ethrms.entity.Shift;
import tech.eikona.ethrms.service.ShiftService;



@Controller
public class ShiftController {

	@Autowired
	private ShiftService shiftService;

	@GetMapping("/shift")
	public String list(Model model) {
		model.addAttribute("Shift", shiftService.getAll());
		return "shift/shift_list";
	}

	@GetMapping("/shift/new")
	public String newEntity(Model model) {

		Shift shift = new Shift();
		model.addAttribute("shift", shift);
		return "shift/shift_new";
	}

	@PostMapping("/shift/save")
	public String saveEntity(@ModelAttribute("shift") Shift shift) {

		shiftService.save(shift);
		return "redirect:/shift";
	}

	@GetMapping("/shift/update/{id}")
	public String updateEntity(@PathVariable(value = "id") long id, Model model) {

		Shift shift = shiftService.getById(id);
		model.addAttribute("shift", shift);
		return "shift/shift_new";
	}

	@GetMapping("/shift/delete/{id}")
	public String deleteEntity(@PathVariable(value = "id") long id) {

		this.shiftService.deleteById(id);
		return "redirect:/shift";
	}

}
