package com.japerfect.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class PublicController {

	@RequestMapping("/index")
	public String home(){
		return "publicHome";
	}
}
