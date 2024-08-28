package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	
	@Value("${myenv.name}")
	private String name;
	
	@Value("${myenv.id}")
	private String id;
	
	@GetMapping("/testenv")
	public Map<String,Object> testEnvVariables() {
		Map<String,Object> response = new HashMap<String,Object>();
		System.out.println("============myenv.name::"+name);
		System.out.println("============myenv.id::"+id);
		
		response.put("name", name);
		response.put("id", id);
		
		return response;
		
	}

}
