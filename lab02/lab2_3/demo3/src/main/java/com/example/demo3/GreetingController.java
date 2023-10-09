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
		@RequestParam(name="name", required=false, defaultValue="World") String name) {
		String message = "Hi, " + name;
		return new Greeting(message);
	}

}
