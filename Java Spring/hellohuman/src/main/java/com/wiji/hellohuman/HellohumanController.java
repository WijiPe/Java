package com.wiji.hellohuman;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HellohumanController {
	
	@RequestMapping("")
    public String index(
    		@RequestParam(value="name", required=false) String name,
    		@RequestParam(value="last_name", required=false) String last_name,
    		@RequestParam(value="times", required=false) Integer times) {
        
		if(name != null && last_name != null && times != null ) {
        	String greeting = "Hello" + name + " " + last_name;
        	return greeting.repeat(times);
//        	String result = "";
//        	
//        	for(int i=0; i < times; i++) {
//        		result += greeting;
//        	}
//        	return result;
   
        }else if(name != null && last_name!= null){
        	return "Hello " + name + " " + last_name ;
        }
			return "You searched for: nothing";
    	}

}
