package com.elvino.ribbon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRibbonRest {

	@GetMapping("/fetch")
	public String fetch() {
		return "Fetched";
	}
}
