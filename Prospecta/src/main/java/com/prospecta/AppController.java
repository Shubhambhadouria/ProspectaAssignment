package com.prospecta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/entries/{categories}")
	public List<ResultDTO> getAllEntriesHandler(@PathVariable("category") String category){
		
		Data data = restTemplate.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entry> entries = data.getEntries();
		
		List<ResultDTO> list = new ArrayList<>();
		
		for(Entry entry : entries) {
			if(entry.getCategory().equals(category)) {
				list.add(new ResultDTO(entry.getApi(),entry.getDescription()));
			}
		}
		return list;
	}
	
	@PostMapping("/entries")
	public ResponseEntity<String> saveEntriesHandler(@RequestBody Entry entry){
		
		Data data = restTemplate.getForObject("", Data.class);
		List<Entry> entries = data.getEntries();
		entries.add(entry);
		String s = "Added";
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	
	
}
