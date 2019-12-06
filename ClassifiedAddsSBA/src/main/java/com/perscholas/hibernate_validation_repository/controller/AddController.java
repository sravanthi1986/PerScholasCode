package com.perscholas.hibernate_validation_repository.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.hibernate_validation_repository.models.Add;
import com.perscholas.hibernate_validation_repository.repository.AddRepository;

@Controller
public class AddController {
	
	@Autowired
	AddRepository addRepository;
	
	@GetMapping("/addController")
	public String showAdd(Model model) throws SQLException {
		List<Add> allAdds = addRepository.showAdds();
		model.addAttribute("allAdds", allAdds);
		model.addAttribute("add", new Add());
		return "Adds";
	}
	
	@PostMapping("/addAdd")
	public String addAdd(@Valid @ModelAttribute("add") Add add, 
			BindingResult result, Model model) 
					throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			List<Add> allAdds = addRepository.showAdds();
			model.addAttribute("allAdds", allAdds);
			return "Adds";
		}
		
		add.setStatus(1);
		Integer addId = addRepository.addAdd(add);

		if (addId == -1) {
			List<Add> allAdds = addRepository.showAdds();
			model.addAttribute("allAdds", allAdds);
			model.addAttribute("errorMessage", "Add add failed.");
			return "Adds";
		}
		
		return "redirect:/addController";
	}
	
	@GetMapping("/removeAdd/{addId}")
	public String removeAdd(@PathVariable Integer addId) 
			throws IOException, SQLException {
		Boolean b = addRepository.removeAdd(addId);
		System.out.println(b);
		return "forward:/addController";
	}
	
	@GetMapping("/orderAdd/{addStatus}")
	public String orderAdd(@PathVariable Integer addStatus) 
			throws IOException, SQLException {
		Boolean b = addRepository.updateStatusOne(addStatus);
		System.out.println(b);
		return "forward:/addController";
	}
	
	@GetMapping("/cancelAdd/{addStatus}")
	public String cancelAdd(@PathVariable Integer addStatus) 
			throws IOException, SQLException {
		Boolean b = addRepository.updateStatusTwo(addStatus);
		System.out.println(b);
		return "forward:/addController";
	}
	
}