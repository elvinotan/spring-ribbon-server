package com.elvino.ribbon;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRibbonRest {

	@GetMapping("/fetch")
	public String fetch() {
		return "Fetched dari 9085";
	}
	
	@GetMapping("/feignGet/{nomor}")
	public Map<String, Object> feignGet(@PathVariable("nomor") Long nomor, @RequestParam("nama") String nama) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nomor ", nomor);
		map.put("nama ", nama);
		return map;
	}
	
	@PostMapping("/feignPost/{nomor}")
	public Map<String, Object> feignPost(@PathVariable("nomor") Long nomor, @RequestBody Map<String, Object> param) {
		param.put("Nomor", nomor);
		return param;
	}
}
