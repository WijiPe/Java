package com.wiji.hellohuman;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HellohumanController {
	

//	@RequestMapping("")
//	public String greeting() {
//		return "Hello Human";
//			
//	}
	
	@RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
        if(searchQuery == null) {
        	return "You searched for: " + "nothing";
        }
		return "You searched for: " + searchQuery;
    }

}
