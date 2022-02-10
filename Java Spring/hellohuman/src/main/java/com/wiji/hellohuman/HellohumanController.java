package com.wiji.hellohuman;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HellohumanController {
	
	@RequestMapping("")
    public String index(@RequestParam(value="name", required=false) String name, String last_name, int times) {
        if(name == null) {
        	return "You searched for: nothing";
        }
		return "Hello " + name + " " + last_name;
    }

}
