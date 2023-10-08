package com.example.demo3;

//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;	//added for Rest endpoint

@RestController
public class GreetingController {

	@GetMapping("/api/greeting")
	public Greeting greeting(
		@RequestParam(name="name", required=false, defaultValue="World") String name, 
		@RequestParam(name = "customMessage", required = false, defaultValue = "Hello,") String customMessage) {
		String message = customMessage + ", " + name;
		return new Greeting(message);
	}

}
