package com.prospecta;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Entry {

	@JsonProperty("API")
	private String api;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Auth")
	private String auth;
	
	@JsonProperty("Https")
	private boolean https;
	
	@JsonProperty("Cors")
	private String cors;
	
	@JsonProperty("Category")
	private String category;
	
	
	
}
