package com.example.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(
		@RequestParam(name="name", required=false, defaultValue="World") String name, 
		@RequestParam(name = "customMessage", required = false, defaultValue = "Hello,") String customMessage,
	Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
