package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
	@GetMapping("/")
	@ResponseBody
	public String helloworld() {
		return "Hello world!";
	}
	@GetMapping("/bye")
	@ResponseBody
	public String adiosmundo() {
		return "Bye cruel world!";
	}
}