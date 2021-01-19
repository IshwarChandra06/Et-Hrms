package tech.eikona.ethrms.controller;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tech.eikona.ethrms.entity.Contractor;
import tech.eikona.ethrms.service.ContractorService;

@Controller
public class ContractorController {

	@Autowired
    private ContractorService contractorService;

  
    @GetMapping("/contractor")
    public String list(Model model)
    {
        model.addAttribute("Contractor", contractorService.getAll());
        return "contractor/contractor_list";
    }
    @GetMapping("/contractor/new")
    public String newEntity(Model model)
    {
      
    	Contractor contractor = new Contractor();
        model.addAttribute("contractor", contractor);
        return "contractor/contractor_new";
    }
    
    @PostMapping("/contractor/save")
    public String saveEntity(@ModelAttribute("contractor") Contractor contractor)
    {
       
    	contractorService.save(contractor);
        return "redirect:/contractor";
    }
    
    
    @GetMapping("/contractor/update/{id}")
    public String updateEntity(@PathVariable ( value = "id") long id, Model model) {
     
     
    	Contractor contractor = contractorService.getById(id);
     model.addAttribute("contractor",contractor);
     return "contractor/contractor_edit";
    }
    
    
    
    @GetMapping("/contractor/delete/{id}")
    public String deleteEntity(@PathVariable (value = "id") long id) 
    {
     
     this.contractorService.deleteById(id);
     return "redirect:/contractor";
    }
}


