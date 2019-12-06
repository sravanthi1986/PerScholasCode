package com.perscholas.vechicle.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.vechicle.model.Vechicle;


@RestController
public class VechicleController {
	
	private Map<Integer, Vechicle> vechicleMap;
	private ObjectMapper  mapper;
	
	@Autowired
	public VechicleController(Map<Integer, Vechicle> vechicleMap, 
			ObjectMapper mapper) {
		this.mapper = mapper;
		this.vechicleMap = vechicleMap;
	}
	
	@GetMapping(value = "/", produces = "text/html")
	public String showStringMessage() {
		return "<h1 style='color: green;'>Hello from vechicle @RestController!</h1>";
	}
	@GetMapping("/vechicle/{id}")
	public String getVechicle(@PathVariable Integer id) throws JsonProcessingException {
		/* The ObjectMapper class is part of the Jackson library which 
		 * provides the ability to read and write JSON either to or from 
		 * POJOs or to or from a JSON Tree Model. In this case we will write a 
		 * JSON string from a Student object and return it as part of the HTTP 
		 * response. You can read more about ObjectMapper at the following 
		 * website: https://fasterxml.github.io/jackson-databind/javadoc/2.7/com
                 * /fasterxml/jackson/databind/ObjectMapper.html */
		
		if (vechicleMap.get(id) != null) {
			Vechicle vechicle = vechicleMap.get(id);
			/* The student properties are returned to the client (e.g., browser) 
			 * as a JSON string. */
			return mapper.writeValueAsString(vechicle);
		} 
		// The error String is returned to the web client
		return "vechicle ID not found";
	}
//		@GetMapping("/getAllVechicle")
//	public String getAllMembers() throws JsonProcessingException {
//		return mapper.writeValueAsString(this.vechicleMap);
//	}

}
